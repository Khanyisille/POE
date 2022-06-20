package Task1;



import javax.swing.JOptionPane;

public class Task1 {
   static Login loginObject = new Login();
    
    static TaskDetails infoObject = new TaskDetails();

    private static String firstName;
    private static String userName;
    private static  String password;
    private static String Lastname; 
    
    
    
    
    public static void setUserName(){
        userName = JOptionPane.showInputDialog("Can you please enter a username that has, at least, five characters"
                + "and contains an underscore");
        
    }
    
    public static String getUserName(){
        
        return userName;
    }
    
    public static void setPassword(){
        password = JOptionPane.showInputDialog("May you please enter a password that has at most 8 characters, and includes a "
                + "special character and has an uppercase");
    }
    
    public static String getPassword(){
        
        return password;
    }
    
    public static void setFirstName(){
        firstName = JOptionPane.showInputDialog("May you please enter your name");
    }
    
    public static String getFirstName(){
        
        return firstName;
    }
    
    public static void setLastname(){
        Lastname = JOptionPane.showInputDialog("May you please enter your surname");
    }
    
    public static String getLastname(){
        
        return Lastname;
    }
    
    
    
    
    public static void main(String[] args) {
        
       setFirstName();
       setLastname();
       setUserName();
       setPassword();
        
        
        JOptionPane.showMessageDialog(null, loginObject.registerUser());
       
       infoObject.welcomeAndChooseOption();
       
     
    }
    
}
