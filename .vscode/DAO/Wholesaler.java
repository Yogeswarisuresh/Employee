import java.sql.*;
public class Wholesaler {
    Connection con=null;
    public Wholesaler() throws SQLException
    {
        Dbconnection db=new Dbconnection();
        con=db.dbConnection();   
    }
    public void displayWholesalers() throws SQLException
    {
        String q="SELECT * FROM wholesalers;";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        System.out.println("W_ID W_NAME    W_MOBILENO   PRO_NAME");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4));
        }
    }
    public void addWholesaler(String id,String name,String mob,String pro) throws SQLException
    {
        String q="INSERT INTO wholesalers VALUES('"+id+"','"+name+"','"+mob+"','"+pro+"');";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+" are affected");
    }
}
