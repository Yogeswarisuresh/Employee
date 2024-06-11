import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        
        Regex reg=new Regex();
        System.out.println("WELCOME");
        System.out.println();
        System.out.println("Enter your E-Mailid");
        String mailid=sc.next();
        System.out.println();
        System.out.println("Enter your password");
        String password=sc.next();
        Adm a=new Adm();
        boolean b=reg.regexPatt(mailid,password);
        if(mailid.equals(a.getmailid())&&password.equals(a.getPass())&&b==true)
        {
            System.out.println("-----***** WELCOME ADMIN *****-----");
            Manager mg=new Manager();
            mg.manager();
        }
        else 
        {
            System.out.println("Enter a valid mail id or password");
        }
        sc.close();
    }
}
