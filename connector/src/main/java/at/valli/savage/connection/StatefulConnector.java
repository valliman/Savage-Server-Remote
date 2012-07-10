package at.valli.savage.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright Passion Soft OG 2012
 * Author: Stefan Vallaster
 * Date: 07.07.12 - 14:55
 */
public class StatefulConnector {

    private static final int SOCKET_TIMEOUT = 500;


    private String host;
    private int port;
    private String password;

    public StatefulConnector(String host, int port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
    }


    public void check() throws ConnectionException {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), SOCKET_TIMEOUT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
            if (socket != null && socket.isConnected()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }

        String response = execute("svr_adminpassword");

        if (response != null) {
            Pattern pattern = Pattern.compile("(.*) is \"(.*)\"");
            Matcher matcher = pattern.matcher(response);

            if (matcher.find()) {
                String cmd = matcher.group(1);
                String pw = matcher.group(2);
                if (!(cmd.equals("svr_adminpassword") && (pw.equals(password)))) {
                    throw new ConnectionException("Password invalid!");
                }
            }
        }
    }

    public String execute(String command) throws ConnectionException {

        String cookie = cookie();
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

    private String cookie() throws ConnectionException {

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
