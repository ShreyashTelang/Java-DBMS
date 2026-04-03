import java.sql.*;

public class Oracle_Connection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@//localhost:8080/XE";
            String user = "system";
            String password = "hr";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Oracle Database!");
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE students (" +
                         "id NUMBER PRIMARY KEY, " +
                         "name VARCHAR2(50), " +
                         "age NUMBER)";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
