import java.sql.*;
public class Materials {
    Connection con=null;
    public Materials() throws SQLException
    {
        Dbconnection db=new Dbconnection();
        con=db.dbConnection();  
    }
    private String m_count;
    public Materials(String m_count)
    {
        this.m_count=m_count;
    }
    public void setMcount(String mcount)
    {
        this.m_count=mcount;
    }
    public String getMcount()
    {
        return m_count;
    }
    public void displayMaterials() throws SQLException
    {
        String q="SELECT * FROM materials;";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(q);
        System.out.println("PRO_ID M_ID M_NAME   M_COUNT");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"   "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getString(4));
        }
    }
    public void addMaterial(String pro,String id,String name,String count) throws SQLException
    {
        String q="INSERT INTO materials VALUES('"+pro+"','"+id+"','"+name+"','"+count+"');";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+"rows are affected");
    }
    public void deleteMaterial(String id) throws SQLException
    {
        String q="DELETE FROM materials WHERE m_id = '"+id+"' ;";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+"rows are affected");
        
    }
    public void UpdateMaterialCount(String id,int num) throws SQLException
    {
        String mcount=getMaterialCount(id);
        int pcount=Integer.parseInt(mcount);
        int t_count=pcount-num;
        String count=String.valueOf(t_count);
        setMcount(count);
        String q="UPDATE materials SET m_count ='"+count+"' WHERE m_id ='"+id+"';";
        Statement st=con.createStatement();
        int rows=st.executeUpdate(q);
        System.out.println(rows+"rows are affected");
    }
    public String getMaterialCount(String mid)
    {
        String q="SELECT m_count FROM materials WHERE m_id='"+mid+"';";
        try 
        {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(q);
            if(rs.next()){
            String count=rs.getString(1);
            return count;
            }else{
                System.out.println("No material count found");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}
