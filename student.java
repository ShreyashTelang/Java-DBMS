import java.sql.*;

public class student {

    static final String url = "jdbc:mysql://localhost:3306/shreyashdb";
    static final String user = "root";
    static final String password = "root123";

    public static void main(String[] args) {

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            // INSERT
            String insertQuery = "INSERT INTO Student VALUES(3,'Rohan','Delhi')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Record Inserted");

            // SELECT
            String selectQuery = "SELECT * FROM Student";
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\nStudent Records:");
            while(rs.next())
            {
                int roll = rs.getInt("RollNo");
                String name = rs.getString("Student_Name");
                String address = rs.getString("Address");

                System.out.println(roll + " " + name + " " + address);
            }

            // UPDATE
            String updateQuery = "UPDATE Student SET Address='Pune' WHERE RollNo=3";
            stmt.executeUpdate(updateQuery);
            System.out.println("\nRecord Updated");

            // DELETE
            String deleteQuery = "DELETE FROM Student WHERE RollNo=3";
            stmt.executeUpdate(deleteQuery);
            System.out.println("Record Deleted");

            // Close Connection
            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}