package at.valli.savage.connection;

import android.util.Log;
import at.valli.savage.domain.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created 25.03.12 - 15:52
 *
 * @author valli
 */
public class Connector {

    private static final String TAG = Connector.class.getName();

    private static Connector instance;

    private Connector() {
    }

    public static Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    public void connect(Server server) throws ConnectionException {

        String response = execute(server, "svr_adminpassword");

        if (response != null) {
            Pattern pattern = Pattern.compile("(.*) is \"(.*)\"");
            Matcher matcher = pattern.matcher(response);

            if (matcher.find()) {
                String cmd = matcher.group(1);
                String pw = matcher.group(2);
                if (!(cmd.equals("svr_adminpassword") && (pw.equals(server.getPassword())))) {
                    throw new ConnectionException("Password invalid");
                }
            }
        }
    }

    public String execute(Server server, String command) throws ConnectionException {

        return execute(server.getHost(), server.getPort(), server.getPassword(), command);

    }

    private String execute(String host, Integer port, String password, String command) throws ConnectionException {

        String cookie = cookie(host, port);
        Socket socket = new Socket();
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket.connect(new InetSocketAddress(host, port), 500);
            if (socket.isConnected()) {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                if (cookie != null) {
                    out.write("svcmd" + " " + cookie + " " + password + " " + command);
                    out.flush();

                    return read(in).trim();
                } else {
                    throw new ConnectionException("Cookie malformed!");
                }
            } else {
                throw new ConnectionException("Connection timeout!");
            }
        } catch (IOException e) {
            throw new ConnectionException("Connection error", e);
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            if (socket.isConnected()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }

    private String cookie(String host, Integer port) throws ConnectionException {

        Socket socket = new Socket();
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket.connect(new InetSocketAddress(host, port), 500);
            if (socket.isConnected()) {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.write("KS_HI");
                out.flush();

                String response = read(in).trim();
                if (response != null && response.length() > 6 && response.startsWith("SV_HI ")) {
                    return response.substring(6, response.length());
                } else {
                    throw new ConnectionException("Cookie malformed");
                }
            } else {
                throw new ConnectionException("Connection timeout");
            }
        } catch (IOException e) {
            throw new ConnectionException("Connection error", e);
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            if (socket.isConnected()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }

    private String read(BufferedReader in) {
        try {
            StringBuilder response = new StringBuilder();

            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
                response.append("\n");
            }

            return response.toString();
        } catch (IOException e) {
            return null;
        }
    }
}