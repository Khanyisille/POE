package Task1;

import javax.swing.JOptionPane;


public class Login {
     String enterUserName; 
    String enterPassword; 
      
    
    /*The following method determines whether or not the user name contains an underscore 
    and is less than five characters long.
The conditions after the return keyword are the first to be checked. 
    If they're true, the method returns true; if they're false, the method returns false.*/
    
    public  boolean checkUserName(){
        
        return (Task1.getUserName().contains("_") && Task1.getUserName().length() <= 5);
        
    }
    
    //This method will returns true if the entered password meets the complexity conditions
    public boolean checkPasswordComplexity(){
        /*
       All of the boolean variables below start out as false. 
       When the loop in this method is entered, each character of the supplied password will be isolated and examined, 
       the variables will be updated to true when the provided conditions are met. 
       The variable will not be changed if a specific condition is not met.
        */
        boolean isUpper = false ;        
        boolean isSpecialCharacter = false ;
        boolean isNumber = false;
        char currentCharacter; 
        
          if (Task1.getPassword().length() >= 8) {
                //the following statements will be only gotten executed if password has at least 8 characters
            
            //this loop repeated through the password and that will enable the examination of one character at a time
            for (int i = 0; i < Task1.getPassword().length(); i++) {
                /* The currentCharacter variable is assigned to the character at the index of the current iteration and 
                inspected to see if it is a Number, an Uppercase letter, or a Spacial character.
                */
                currentCharacter = Task1.getPassword().charAt(i);  
                if (Character.isUpperCase(currentCharacter)) {
                    isUpper = true;
                } else if (Character.isDigit(currentCharacter)) {
                    isNumber = true;
                } else if (!(Character.isLetterOrDigit(currentCharacter))) {
                    isSpecialCharacter = true;
                }
                
                }
            }

       /*The conditions after the return keyword are the first to be checked. 
          The method checkPasswordComplexity will return true if they are both true, 
          and false if they are both false.*/
    
           return (isUpper && isNumber && isSpecialCharacter);   
    }
   
    //If the username and password conditions are met, the following procedure produces an acceptable message.
    
 public String registerUser(){
     
     String nameMessage;
     String passwordMessage;
     /*The username will be collected if checkUserName returns true. 
     If this is not the case, an error notice will be displayed.*/
     
     if (checkUserName()){
         nameMessage = "The username successfully captured; ";
     }
     else{
         nameMessage = "The username not correctly formatted, may you please ensure that your name contains an underscore and"
                 + " is no more than 5 characters long ";
     }
     // The password will be captured if the password complexity conditions are met. If this is not the case, an error message is displayed.
     if(checkPasswordComplexity()){
         passwordMessage = "The password has been successfully captured.";
     }
     else{
        passwordMessage = " The password has not been correctly formatted, may you please make sure that the password contains "
                + ", a capital letter, a number and a special character.";
     }
    return passwordMessage + "\n" + nameMessage;
 }
 
 /* If both the user name and password are correctly formatted, 
 the following function returns true. Otherwise, false is returned.*/
 
 
 public boolean loginUser(){
     
     /* If the username and password complexity conditions were met during registration, 
     the user was only required to submit login information.
     */
     if (checkUserName() && checkPasswordComplexity()){
        
     //The user is asked to provide their password as well as the username they used to sign up.
        enterUserName = JOptionPane.showInputDialog("Can you please enter the username you provided in the begining");
        
        enterPassword = JOptionPane.showInputDialog("Can you please enter the password you provided in the begining");
     
        
        
     }
     return Task1.getUserName().equals(enterUserName) && Task1.getPassword().equals(enterPassword);
           
 }
 
    // The following method will welcomes the user if the loginUser() returns to be true.
 public String returnLoginStatus(){
      
      String welcomeMessage; 
      /*
        To avoid sending unwanted messages, the login status is only returned if the user was successful in creating an account.
        In that instance, depending on whether the login information matches the information used to create the account, 
        a corresponding message will be presented.*/
      
    
         if(loginUser()){
             welcomeMessage = " Welcome " + Task1.getFirstName() +" " + Task1.getLastname()
                     + " it is wonderfull to see you again";
         }
         else{
             welcomeMessage = " Password or the username is incorrect, may you please try again.";
         }
     
     return welcomeMessage;
   }
}

