import java.util.Scanner;
public class User 
{
    public void user() throws Exception
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to veiw owner data");
        System.out.println("Enter 2 to veiw customer data");
        System.out.println("Enter 3 to veiw Products data");
        System.out.println("Enter 4 to view Staff data");
        System.out.println("Enter 5 to view wholesaler data");
        System.out.println("Enter 6 to view Materials data");
        System.out.println("Enter 7 to view Orders data");
        int choice=sc.nextInt();
        if(choice==1)
        {
            Owners owner=new Owners();
            owner.displayOwners();
        }
        else if(choice==2)
        {
            Customer cust=new Customer();
            cust.displayCustomer();
        }
        else if(choice==3)
        {
            Products pro=new Products();
            pro.displayProducts();
        }
        else if(choice==4)
        {
            Staff st=new Staff();
            st.displayStaff();
        }
        else if(choice==5)
        {
            Wholesaler ws=new Wholesaler();
            ws.displayWholesalers();
        }
        else if(choice==6)
        {
            Materials mat=new Materials();
            mat.displayMaterials();
        }
        else if(choice==7)
        {
            Orders order=new Orders();
            order.displayOrders(); 
        }
        sc.close();
    }
}
