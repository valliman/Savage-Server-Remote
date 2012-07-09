package model;

import at.valli.savage.connection.ConnectionException;
import at.valli.savage.connection.StatefulConnector;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 09.07.12
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionManager {
    StatefulConnector connector;

    public ConnectionManager(String ip, String port, String password) {
        connector=new StatefulConnector(ip, Integer.parseInt(port), password);
        try {
            connector.connect();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            connector.disconnect();
        } catch (ConnectionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void set(String name, String value) {
        try {
            connector.execute("set "+name+"\""+value+"\"");
        } catch (ConnectionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void execute(String cmd) {
        try {
            connector.execute(cmd);
        } catch (ConnectionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
