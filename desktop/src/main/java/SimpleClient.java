import at.valli.savage.connection.ConnectionException;
import at.valli.savage.connection.Connector;
import at.valli.savage.connection.StatefulConnector;

import java.util.Scanner;

/**
 * Copyright Passion Soft OG 2012
 * Author: Stefan Vallaster
 * Date: 07.07.12 - 10:45
 */
public class SimpleClient {

    private StatefulConnector connector;
    private String host;
    private int port;
    private String password;

    public SimpleClient() {

    }

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("SYNOPSIS: java -jar <jar> <host> <port> <password>");
        } else {

            SimpleClient app = new SimpleClient();
            app.setHost(args[0]);
            app.setPort(Integer.parseInt(args[1]));
            app.setPassword(args[2]);

            app.execute();
        }

    }

    private void execute() {
        Scanner scanner = null;
        try {
            connector = new StatefulConnector(host, port, password);
            connector.connect();
            scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String cmd = scanner.nextLine();
                System.out.println("EXECUTING: " + cmd);
                System.out.println(connector.execute(cmd));
            }
        } catch (ConnectionException e) {
            System.err.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            try {
                if (connector.isConnected()) {
                    connector.disconnect();
                }
            } catch (ConnectionException ignored) {
            }
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
