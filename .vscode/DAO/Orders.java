import java.sql.*;
public class Orders 
{
    Connection con=null;
    public Orders() throws SQLException
    {
        Dbconnection db=new Dbconnection();
        con=db.dbConnection();   
    }
    public void displayOrders() throws SQLException
    {
        String q="SELECT * FROM orders;";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        System.out.println("O_ID   C_ID  PRO_ID M_ID  DATE       AMOUNT PRO_QTY");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7));
        }
    }
   
    public void addOrders(String id,String cid,String pid,String mid,String date,int num,String amount) throws SQLException
    {
        String q="INSERT INTO orders VALUES('"+id+"','"+cid+"','"+pid+"','"+mid+"','"+date+"','"+num+"','"+amount+"');";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+"rows are affected");
    }
}
