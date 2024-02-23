import java.sql.*;
public class Customer 
{
    Connection con=null;
    public Customer() throws SQLException
    {
        Dbconnection db=new Dbconnection();
        con=db.dbConnection();   
    }
    public void displayCustomer() throws SQLException
    {
        String q="SELECT * FROM customer;";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        System.out.println("C_ID   C_NAME  C_MOBILE     C_MAIL-ID         C_ADDRESS");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getString(5));
        }
    }
    public void addCustomer(String id,String name,String mobile,String mail,String address) throws SQLException
    {
        String q="INSERT INTO customer VALUES("+id+",'"+name+"','"+mobile+"','"+mail+"','"+address+"');";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+" are affected");
    }
}
