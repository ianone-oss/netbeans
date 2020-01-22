import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    public static Connection con;
    public static Statement stm;
    
    public static void main(String[] args){
        try {
            String url;
            url="jdbc:mysql://localhost/pos40";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            stm=con.createStatement();
            System.out.println("koneksi berhasil");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
    }
    
    private static Connection mysqlkonek;
    public static Connection koneksiDB() throws SQLException {
        if(mysqlkonek==null){
            try {
                String DB="jdbc:mysql://localhost/pos40";
                String user="root";
                String pass="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"gagal koneksi");
            }
        }
        return mysqlkonek;
    }
}
