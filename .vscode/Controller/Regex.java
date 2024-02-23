import java.util.regex.*;
public class Regex 
{

    public boolean regexPatt(String mailid,String pass)
    {
       Pattern p1=Pattern.compile("[a-z|A-Z]+@gmail.com([0-9]+)");
       Matcher m1=p1.matcher(mailid);
       Pattern p2=Pattern.compile("[a-z|A-Z]+[0-9]+");
       Matcher m2=p2.matcher(pass);
       if(m1.find()&&m2.find())
       {
          return true;
       }
       else 
       {
          return false;
       }
    }
}
