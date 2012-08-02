package model;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 02.08.12
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class Favorite {
    int id;
    String ip;
    int port;
    String password;

    public Favorite(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Favorite(String ip, int port, String password) {
        this.ip = ip;
        this.port = port;
        this.password = password;
    }

    public Favorite(int id, String ip, int port, String password) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
