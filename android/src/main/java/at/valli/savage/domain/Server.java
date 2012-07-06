package at.valli.savage.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created 25.03.12 - 17:29
 *
 * @author valli
 */
public class Server implements Parcelable {

    private Long id;
    private String name;
    private String host;
    private int port;
    private String password;

    public Server() {
    }

    public Server(Parcel in) {
        id = in.readLong();
        name = in.readString();
        host = in.readString();
        port = in.readInt();
        password = in.readString();
    }

    public Server(String host, int port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Server server = (Server) o;

        if (id != server.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(id);
        out.writeString(name);
        out.writeString(host);
        out.writeInt(port);
        out.writeString(password);
    }

    public static final Parcelable.Creator<Server> CREATOR
            = new Parcelable.Creator<Server>() {
        public Server createFromParcel(Parcel in) {
            return new Server(in);
        }

        public Server[] newArray(int size) {
            return new Server[size];
        }
    };

}
