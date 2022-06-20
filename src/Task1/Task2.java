package Task1;


public class Task2 {
    
static TaskDetails detailObject = new TaskDetails();
    
    // If the task description is less than 51 characters long, this method returns true; otherwise, it returns false.
    public static boolean checkTaskDescription(){
        final int DESCRIPTION_LENGTH = 50;
        if(detailObject.getDescription().length() <= DESCRIPTION_LENGTH){
            return true;
        }
        else{
            return false;
        }
    }
    
    /* Using some of the task details provided by the user, the following procedure will automatically construct an ID for each task.*/
    
    public static String createTaskID(){
        
        /*
            This loop will be repeated until all of the programmers' names have been used.
When a white space is found, the software assumes the first name has come to an end, and it will count back three steps from the whitespace before creating a substring from that place to the end.

the letter immediately preceding the whitespace

The final three letters of the programmer's first name will be saved in the variable below.
        */
        String lastThreeLetters = "";
        
        char ch; // The following variable will hold each letter of the programmer's name as it is getting repeated through the program
        
        for(int i = 0; i < detailObject.getDeveloperNames().length(); i++){
            
            ch = detailObject.getDeveloperNames().charAt(i);
            
            if(ch == ' '){
                lastThreeLetters = detailObject.getDeveloperNames().substring(i-3, i);
            }
        }
       
        
        
   String id =  detailObject.getTaskName().substring(0, 2) + ":" +detailObject.getTaskNumber() +
           ":" + lastThreeLetters;
   
  
    return id.toUpperCase();
    }
    
    /*
    this method will returns all of the information of a specific task.
    */
    public static String printTaskDetails(){
        return detailObject.getStatus() + "\n" + detailObject.getDeveloperNames() + "\n" +  
                detailObject.getTaskNumber() + "\n" + detailObject.getTaskName() + "\n" +
                detailObject.getDescription() + "\n" +createTaskID() + "\n" + detailObject.getDuration();
    }
    
    //The following method will returns the number of hours that are required to complete all the tasks
    public static int returnTotalHours(){
        
        return detailObject.sumOfHours;
    }
}

