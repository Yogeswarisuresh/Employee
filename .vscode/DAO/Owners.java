import java.sql.*;
public class Owners 
{
    Connection con=null;
    public Owners() throws SQLException
    {
        Dbconnection db=new Dbconnection();
        con=db.dbConnection();   
    }
    public void displayOwners() throws SQLException
    {
        String q="SELECT * FROM owners;";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        System.out.println("Owner_ID  Owner_Name  Owner_Share%");
        while(rs.next())
        {
           System.out.println(rs.getString(1)+"         "+rs.getString(2)+"       "+rs.getString(3));
        }
    }
}
