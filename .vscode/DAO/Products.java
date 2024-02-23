import java.sql.*;
public class Products 
{
    Connection con=null;
    private String pro_count;
    public Products(String pro_count)
    {
        this.pro_count=pro_count;
    }
    public void setPro_count(String avail)
    {
        this.pro_count=avail;
    }
    public String getPro_count()
    {
        return pro_count;
    }
    public Products() throws SQLException
    {
        Dbconnection db=new Dbconnection();
        con=db.dbConnection();   
    }
    public void displayProducts() throws SQLException
    {
        String q="SELECT * FROM products;";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        System.out.println("PRO_ID PRO_NAME  PRO_COUNT");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"   "+rs.getString(2)+"    "+rs.getString(3));
        }
    }
    public void addProducts(String id,String name,String count) throws SQLException
    {
        String q="INSERT INTO products VALUES('"+id+"','"+name+"','"+count+"');";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+"rows are affected");
    }
    public void addExistProCount(String pid,int num)
    {
        String avail=getProductCount(pid); 
        int pcount=Integer.parseInt(avail);
        int t_count=pcount+num;
        String count=String.valueOf(t_count);
        setPro_count(count);
        String q="UPDATE products SET pro_count = '"+count+"' WHERE pro_id = '"+pid+"';";
        try{
            Statement st=con.createStatement();
            int rows=st.executeUpdate(q);
            System.out.println(rows+"rows are affected");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
    }
    public void deleteProduct(String id) throws SQLException
    {
        String q="DELETE FROM products WHERE pro_id = '"+id+"' ;";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+"rows are affected");
    }
    public void UpdateProductCount(String id,int num) throws SQLException
    {
        String avail=getProductCount(id); 
        int pcount=Integer.parseInt(avail);
        int t_count=pcount-num;
        String count=String.valueOf(t_count);
        setPro_count(count);
        String q="UPDATE products SET pro_count = '"+count+"' WHERE pro_id = '"+id+"';";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+"rows are affected");
    }
    public String getProductCount(String pid)
    {
        String q="SELECT pro_count FROM products WHERE pro_id='"+pid+"';";
        try 
        {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(q);
            if(rs.next())
            {
            String count=rs.getString(1);
            return count;
            }
            else{
                System.out.println("No product count found");
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}