package jdbcexample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DATABASECONECTION {

    /**
     * @param args
     */
    public static void main(String args[]) {
        try {

            String dbServer = "jdbc:mysql://apontejaj.com:3306/Fabiolla_2019226?useSSL=false";
            String user = "Fabiolla_2019226";
            String password = "2019226";
            String query = "INSERT INTO user (fullName,email,phoneNumber, password) VALUES ('fernando', 'fernando@hotmail.com', '1234567', '54321');";

            Connection conn = DriverManager.getConnection(dbServer, user, password);

            Statement stmt = conn.createStatement();

               stmt.execute(query);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
