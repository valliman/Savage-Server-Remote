package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 02.08.12
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */

public class DBManager {
    public Connection con;

    public DBManager()
    {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        try {
            con = (Connection) DriverManager.getConnection("jdbc:sqlite:favorites.db", "root", "");
        } catch (SQLException e) {
           e.printStackTrace();
        }
        createDB();
    }

    public void createDB() {
        Statement stat;
        try {
            stat = con.createStatement();
            stat.executeUpdate("create table if not exists favorites ( id integer primary key autoincrement, ip varchar(15) not null, port integer not null, password varchar(99) not null )");
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Favorite f)
    {
        String sql="INSERT INTO favorites(ip,port,password) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,f.getIp());
            ps.setInt(2, f.getPort());
            ps.setString(3,f.getPassword());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Favorite f)
    {
        String sql="DELETE FROM favorites WHERE ip=? AND port=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,f.getIp());
            ps.setInt(2,f.getPort());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        String sql="DELETE FROM favorites";
        try {
            Statement stat=con.createStatement();
            stat.execute(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Favorite> getAll()
    {
        List<Favorite> erg=new ArrayList<Favorite>();
        String sql="SELECT * FROM favorites";
        try {
            Statement stat=con.createStatement();
            ResultSet rs=stat.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt(1);
                String ip=rs.getString(2);
                int port=rs.getInt(3);
                String password=rs.getString(4);
                Favorite f=new Favorite(id,ip,port,password);
                erg.add(f);
            }
            rs.close();
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return erg;
    }

    public Favorite get(Favorite f) {
        Favorite erg=null;
        String sql="SELECT * FROM favorites WHERE ip=? AND port=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,f.getIp());
            ps.setInt(2,f.getPort());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                int id=rs.getInt(1);
                String ip=rs.getString(2);
                int port=rs.getInt(3);
                String password=rs.getString(4);
                erg=new Favorite(id,ip,port,password);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return erg;
    }

    public void saveList(List<Favorite> list) {
        for(Favorite f:list) {
            save(f);
        }
    }
}
