import java.sql.*;
public class Staff {
    Connection con=null;
    public Staff() throws SQLException
    { 
        Dbconnection db=new Dbconnection();
        con=db.dbConnection();   
    }
    public void displayStaff() throws SQLException 
    {
        String q="SELECT * FROM staffs;";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        System.out.println("S_ID S_NAME  S_ROLE    S_MOBILENO");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"    "+rs.getString(4));
        }
    } 
    public void addStaff(String id,String name,String role,String mobile) throws SQLException
    {
        String q="INSERT INTO staffs VALUES('"+id+"','"+name+"','"+role+"','"+mobile+"')";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+" rows are affected");
    }
    public void deleteStaff(String id) throws SQLException
    {
        String q="DELETE FROM staffs WHERE s_id='"+id+"';";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+" rows are affected");
    }
}
