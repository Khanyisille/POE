package Task1;

import javax.swing.JOptionPane;


public class TaskDetails {
    
 Login loginObject = new Login(); 
    
   
    private static String Taskname ; 
    private static int timespan; 
    private static int option; 
    private static int numberOfTasks; 
   
    
    private static int taskNumber;
    private static String elucidation; 
    private static String devNames; 
    private static String status;
    
    static int sumOfHours = 0; 
    static String taskinfo;
    
  
   
    public void setTaskName(){
        Taskname = JOptionPane.showInputDialog("Please enter the task name ");
    }
    
    public String getTaskName(){
        return Taskname;
    }
    
    //The user prompted to choose an option from the numeric menu and the entered choice is stored in option.
    public void setChosenOption(){
        option = Integer.parseInt(JOptionPane.showInputDialog(
                "Welcome to EasyKanban\n"
                +"PLEASE SELECT AN OPTION\n"
                + "Option 1) Add tasks\n"
                + "Option 2) Show Report\n"
                + "Option 3) Quit"));
        
    }
    
    public int getOPtion(){
        return option;
    }
    
    /*Before it is placed in numberOfTasks, the user is prompted to specify the number of tasks they intend to implement, 
    and their option is turned to an integer..
    */
    public void setNumberOfTasks(){
        numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("May you please enter the number of tasks you would like to add"));
    }
    
    public static int getNumberOfTasks(){
        return numberOfTasks;
    }
    
    /* tThe user's estimated job duration is received, converted to an int, and saved in duration.
    */
    public void setDuration(){
        timespan = Integer.parseInt(JOptionPane.showInputDialog("May you please enter task duration"));
    }
    
    public int getDuration(){
        return timespan;
    }
    
    /*
    The user is prompted to submit a brief description of the task, 
    and the getDescription() method returns the description.
    
    */
    public void setDescription(){
        elucidation = JOptionPane.showInputDialog("May you please enter a task description");
    }
    
    public String getDescription(){
        return elucidation;
    }
    
    
    /*
    The names of the programmers allocated to the task are returned via the following two methods.
    */
    public void setDevNames(){
        devNames = JOptionPane.showInputDialog("May you please enter the ctreator's name and surname");
    }
    
    public String getDeveloperNames(){
        return devNames;
    }
    
   
    public void setStatus(){
        status = JOptionPane.showInputDialog("may you please choose the Status of this task from the three options.\n"
                + "To Do\n"
                + "Doing\n"
                + "Done");
    }
    
    public String getStatus(){
        return status;
    }
    
    
   
    public void setTaskNumber(int TaskNumber){
        taskNumber = TaskNumber;
    }
            
    public int getTaskNumber(){
        return taskNumber;
    }
    

    /*
    The following function checks if the user was able to log in and, if so,
    displays an option menu before calling the setters.
    */ 
    
    public void welcomeAndChooseOption(){
    
        //If the user successfully registers, they will simply receive a welcome message and the option Menu.
        if(loginObject.loginUser()){
            
            
            do{
                setChosenOption();
              
               switch(option){
                    
                case 1: 
                    setNumberOfTasks(); 
                 
                    for(int i = 0; i < getNumberOfTasks() ; i++){ 
                        
                        /*
                            All of the other setters are called here to give the variables their initial values 
                            before they are used for the first time.
                        */
                        setStatus();
                        setTaskNumber(i);
                        setTaskName();
                        setDuration();
                        setDescription();
                        setDevNames();
                        
                    
                        Task2.checkTaskDescription();
                        
                        
                        JOptionPane.showMessageDialog(null, Task2.printTaskDetails());
                        
                        //The next line determines the overall number of hours required to perform all jobs.
                        sumOfHours = sumOfHours + getDuration();
                        
                        
                        
                    }
             
          JOptionPane.showMessageDialog(null,"You will need " +Task2.returnTotalHours()+" hours to be able to complete these tasks.");
                       
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, "Will be coming soon");
                    break;
                case 3: 
                    option = 3;
                    break;
                
                }
            }
            while(option != 3);
            
        }
    
    }
    
}    


