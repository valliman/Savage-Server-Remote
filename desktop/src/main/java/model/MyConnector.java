package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MyConnector {

    private static final int SOCKET_TIMEOUT = 500;

    private String host;
    private int port;
    private String password;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String cookie;

    public MyConnector(String host, int port, String password) throws Exception {
        this.host = host;
        this.port = port;
        this.password = password;
        this.cookie = getCookie();
    }

    public void write(String msg) throws Exception {
        socket = new Socket();
        socket.connect(new InetSocketAddress(host, port), SOCKET_TIMEOUT);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.write(msg);
        out.flush();
    }

    public String read() throws Exception {
        out = new PrintWriter(socket.getOutputStream(), true);
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
        System.out.println("CLIENT: "+msg);
        write(msg);
        String answer=read();
        System.out.println("SERVER: "+answer);
        return answer;
    }

    public String getCookie() throws Exception {
        String msg="KS_HI";
        System.out.println("CLIENT: "+msg);
        write(msg);
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

    public String execute(String cmd) throws Exception {
        return send("svcmd "+cookie+" "+password+" "+cmd);
    }
}
