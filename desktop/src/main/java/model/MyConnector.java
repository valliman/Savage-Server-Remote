package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyConnector {

    private static final int SOCKET_TIMEOUT = 500;

    private String host;
    private int port;
    private String password;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String cookie;
    public boolean check;

    public MyConnector(String host, int port, String password) throws Exception {
        this.host = host;
        this.port = port;
        this.password = password;
        this.cookie = getCookie();
        this.check = check();
    }

    public void write(String msg) throws Exception {
        socket = new Socket();
        socket.connect(new InetSocketAddress(host, port), SOCKET_TIMEOUT);
        out = new PrintWriter(socket.getOutputStream(), true);
        out.write(msg);
        out.flush();
    }

    public String read() throws Exception {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
            response.append("\n");
        }

        return response.toString();
    }

    public String send(String msg) throws Exception {
        write(msg);
        System.out.println("CLIENT: "+msg);
        String answer=read();
        System.out.println("SERVER: "+answer);
        return answer;
    }

    public String getCookie() throws Exception {
        String msg="KS_HI";
        write(msg);
        System.out.println("CLIENT: "+msg);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        System.out.println("SERVER: "+response.toString());
        return response.toString().replace("SV_HI ","");
    }

    public boolean check() throws Exception {
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), SOCKET_TIMEOUT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            return false;
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    // ignore
                }
            }
            if (socket != null && socket.isConnected()) {
                try {
                    socket.close();
                } catch (Exception e) {
                    // ignore
                }
            }
        }

        String response = execute("svr_adminpassword");

        if (response != null && !response.equals("")) {
            Pattern pattern = Pattern.compile("(.*) is \"(.*)\"");
            Matcher matcher = pattern.matcher(response);

            if (matcher.find()) {
                String cmd = matcher.group(1);
                String pw = matcher.group(2);
                if (!(cmd.equals("svr_adminpassword") && (pw.equals(password)))) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

    public String execute(String cmd) throws Exception {
        return send("svcmd "+cookie+" "+password+" "+cmd);
    }
}
