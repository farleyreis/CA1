package jdbcexample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DATABASECONECTION {

        Connection conn = null;
        
        String host = "jdbc:mysql://apontejaj.com:3306/Fabiolla_2019226?useSSL=false";
        String dbName = "user";
        String username = "Fabiolla_2019226";
        String password = "2019226";
        //String driver = "com.mysql.jdbc.Driver";
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        DATABASECONECTION()
        {
                try{
                        //Class.forName(driver);
                        con = DriverManager.getConnection(host , username, password);
                        pst = con.prepareStatement("SELECT fullName, email, phoneNumber, password FROM users");
                }
                catch(Exception e)
                {
                        e.printStackTrace();    
                }
        }
        
        public Boolean vertify(String uname, String pwd)
        {
                try{
                        pst.setString(1, uname); //this replace the 1st "?" in the query for username
                        pst.setString(2, pwd);   //this replace the 2nd "?" in the query for password
                        
                        //execute the prepared statement
                        rs = pst.executeQuery();
                        if(rs.next())
                        {
                                //TRUE iff query founds any corresponding data
                                return true;
                        }
                        else
                        {
                                return false;
                        }                       
                }catch (Exception e)
                {
                        //TODO Auto-generate catch block
                        System.out.println("error while validating" + e);
                        return false;
                }
        }
}