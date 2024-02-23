import java.sql.*;
public class Dbconnection 
{
    Connection con=null;
    public Connection dbConnection() throws  SQLException
    {
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DB","root","Yogi$2004@18");  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}
