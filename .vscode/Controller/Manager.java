import java.util.*;
public class Manager 
{
    public void manager() throws Exception
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to veiw owner data");
        System.out.println("Enter 2 to veiw customer data");
        System.out.println("Enter 3 to veiw Products data");
        System.out.println("Enter 4 to view Staff data");
        System.out.println("Enter 5 to view wholesaler data");
        System.out.println("Enter 6 to view Materials data");
        System.out.println("Enter 7 to view Orders data");
        int choice=0;
        choice=sc.nextInt();
        Owners owner=new Owners();
        Customer cust=new Customer();
        Products pro=new Products();
        Staff sta=new Staff();
        Wholesaler ws=new Wholesaler();
        Materials mat=new Materials();
        Orders od=new Orders();
        if(choice==1)
        {
           owner.displayOwners();
        }
        else if(choice==2)
        {
           System.out.println("Enter 1 to view details of customer");
           System.out.println("Enter 2 to add a customer");
           int option=sc.nextInt();
           if(option==1)
           {
               cust.displayCustomer();
           }
           else if(option==2)
           {
               System.out.println("Enter the Id of customer:");
               String id=sc.next();
               System.out.println("Enter the name of customer:");
               String name=sc.next();
               System.out.println("Enter the mobile no of customer:");
               String mobile=sc.next();
               System.out.println("Enter the mail-id of customer:");
               String mail=sc.next();
               System.out.println("Enter the address of customer:");
               String address=sc.next();
               cust.addCustomer(id,name,mobile,mail,address);
           }
        }
        else if(choice==3)
        {
            System.out.println("Enter 1 to view details of products");
            System.out.println("Enter 2 to add a new product");
            System.out.println("Enter 3 to delete a product");
            System.out.println("Enter 4 to update existing product count");
            int ch=sc.nextInt();
            if(ch==1)
            {
                pro.displayProducts();
            }
            else if(ch==2)
            {
                System.out.println("Enter the id of product");
                String id=sc.next();
                System.out.println("Enter the name of product");
                String name=sc.next();
                System.out.println("Enter the total count of product");
                String count=sc.next();
                pro.addProducts(id, name, count);
            }
            else if(ch==3)
            {
                System.out.println("Enter the id of product to delete");
                String id=sc.next();
                pro.deleteProduct(id);
            }
            else if(ch==4)
            {
                System.out.println("Enter the product id");
                String pid=sc.next();
                System.out.println("Enter the new count");
                int num=sc.nextInt();
                pro.addExistProCount(pid, num);
            }
        }
        else if(choice==4)
        {
            System.out.println("Enter 1 to view details of products");
            System.out.println("Enter 2 to add a new product");
            System.out.println("Enter 3 to delete a product");
            int op=sc.nextInt();
            if(op==1)
            {
                sta.displayStaff();
            }
            else if(op==2)
            {
                System.out.println("Enter the id of staff");
                String id=sc.next();
                System.out.println("Enter the name of staff");
                String name=sc.next();
                System.out.println("Enter the role of staff");
                String role=sc.next();
                System.out.println("Enter the mobile no of staff");
                String mob=sc.next();
                sta.addStaff(id, name, role, mob);
            }
            else if(op==3)
            {
                System.out.println("Enter the id of staff to delete");
                String id=sc.next();
                sta.deleteStaff(id);
            }
        }
        else if(choice==5)
        {
            System.out.println("Enter 1 to view details of wholesaler");
            System.out.println("Enter 2 to add wholesaler");
            int c=sc.nextInt();
            if(c==1)
            {
                ws.displayWholesalers();
            }
            else if(c==2)
            {
                System.out.println("Enter the id of wholesaler");
                String id=sc.next();
                System.out.println("Enter the name of wholesaler");
                String name=sc.next();
                System.out.println("Enter the mobile no");
                String mob=sc.next();
                System.out.println("Enter the product name");
                String p=sc.next();
                ws.addWholesaler(id,name,mob,p);
            }
        }
        else if(choice==6)
        {
            System.out.println("Enter 1 to view details of Materials");
            System.out.println("Enter 2 to add a new Material");
            System.out.println("Enter 3 to delete a Material");
            int opt=sc.nextInt();
            if(opt==1)
            { 
               mat.displayMaterials();
            }
            else if(opt==2)
            {
                System.out.println("Enter the product id of material");
                String prod=sc.next();
                System.out.println("Enter the id of material");
                String id=sc.next();
                System.out.println("Enter the name of material");
                String name=sc.next();
                System.out.println("Enter the count of material");
                String count=sc.next();
                mat.addMaterial(prod, id, name, count);
            }
            else if(opt==3)
            {
                System.out.println("Enter the id of material to delete");
                String id=sc.next();
                mat.deleteMaterial(id);
            }
        } 
        else if(choice==7)
        {
            System.out.println("Enter 1 to view details of orders");
            System.out.println("Enter 2 to add a new order");
            int cho=sc.nextInt();
            if(cho==1)
            {
                od.displayOrders();
            }
            else if(cho==2)
            {
                System.out.println("Enter the order ID");
                String id=sc.next();
                System.out.println("Enter the customer ID");
                String cid=sc.next();
                System.out.println("Enter the date of order");
                System.out.println("NOTE: Date should be in YYYY-MM-DD format");
                String date=sc.next();
                int exit=1;
                while(exit!=0)
                {
                   System.out.println("Enter the product ID");
                   String pid=sc.next();
                   System.out.println("Enter the material ID");
                   String mid=sc.next();
                   System.out.println("Enter the no of products");
                   int num=sc.nextInt();
                   System.out.println("Enter the total amount");
                   String amount=sc.next();
                   String pro_count=pro.getProductCount(pid);
                   String mat_count=mat.getMaterialCount(mid);
                   int m_count=Integer.parseInt(mat_count);
                   int p_count=Integer.parseInt(pro_count);
                   if(m_count>=num&&p_count>=num)
                   {
                   od.addOrders(id, cid, pid, mid, date, num, amount);
                   pro.UpdateProductCount(pid, num);
                   mat.UpdateMaterialCount(mid, num);
                   }
                    else
                   {
                       System.out.println("Out of Stock");
                   }
                   System.out.println("1 for continue orders");
                   exit=sc.nextInt();
                }
            }
        }
        sc.close();
    }
}
