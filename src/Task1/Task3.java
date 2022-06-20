package Task1;

import javax.swing.JOptionPane;


public class Task3 {
   static int option = 0; // This variable will store the user's array manipulation preference.
    static String userChoice; //
    
    static int size = TaskDetails.getNumberOfTasks();
    
    static String[] names = new String[size];
    static String[] taskNames = new String[size];
    static String[] IDs = new String[size];
    static String[] statuses =new String[size];
    static int[] durations = new int[size];
    
    /*
        The user is provided with alternatives to carry out a variety of operations on the task specifics in the following fashion.
    */
    public static void manipulateArrays(String name[], String taskName[], String ID[], String[] status, int duration[]){
       
        //The information can be accessed everywhere thanks to the subsequent lines, which replicate the local arrays into the global arrays.
       
        System.arraycopy(name, 0, names, 0, size);
        System.arraycopy(taskName, 0, taskNames, 0, size);
        System.arraycopy(ID, 0, IDs, 0, size);
        System.arraycopy(status, 0, statuses, 0, size);
        System.arraycopy(duration, 0, durations, 0, size);
        
        
        /*
        Only if the user chooses option 1, will they be given the opportunity to manipulate the arrays.
        */ 
        option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                              Task details captured.
                                                              Press 1 to operate on the captured data or 0 to quit"""));
        do{
            userChoice = JOptionPane.showInputDialog("Enter\n"
                    + "A. To view the list of all tasks with the status of done\n"
                    + "B. To view the name of the developer whose task takes the longest to complete\n"
                    + "C. To search for a Task\n"
                    + "D. To view the list of tasks assigned to a developer\n"
                    + "E. To delete a task\n"
                    + "F. To get a report of all the captured Tasks");
            
            switch(userChoice){
                case "A":       // The user will get the list of done tasks if they select a letter
                    doneTasks();
                    break;
                case "B":
                    longestTask();
                    break;
                case "C":
                    searchTask();
                    break;
                case "D":
                    developerTasks();
                    break;
                case "E":
                    deleteTask();
                    break;
                case "F":
                    displayReport();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " The input value is Invalid");
                    
            }
        
            // The user is asked if they would prefer more array operations.
           
            option = Integer.parseInt(JOptionPane.showInputDialog("Please Press 1 to continue operating on the data and 0 to stop"));
            
        }while(option == 1);

        
    }
    // This technique looks for and shows tasks with the status "Done."
    
    public static void doneTasks(){
        for(int i = 0; i < size; i++){
            if(statuses[i].equals("Done")){
                JOptionPane.showMessageDialog(null, names[i]+"\n"
                        +taskNames[i]+ "\n"
                        +durations[i]+ "");
            }
        }
    }
    
    /* The developerNames associated with the task are displayed with the taskDuration array's largest value, which is found using this function.
    */
    
    public static void longestTask(){
        int maximum;
        maximum = durations[0];
        int position = 0; 

        // The greatest number in the task will be kept in this variable. variety of durations
        
        
        // This loop selects the taskDurations array's highest value and stores it in the maximum variable.
        
        
        for(int i = 0; i < size; i++){
            
            if(durations[i] > maximum){
                maximum = durations[i];
                position = i;
            }                        
        }
        
        JOptionPane.showMessageDialog(null, names[position]+ ", " + maximum);
        
    }
    
    /*
     Using the task name, a user is able to search for a Task using this approach.
    */
    public static void searchTask(){
        String search;
        search = JOptionPane.showInputDialog("Please enter the name of the task to be searched");
        
        for(int i = 0; i < size; i++){
            if(taskNames[i].equals(search)){
                JOptionPane.showMessageDialog(null, taskNames[i] + ", " + names[i] +", "+ statuses[i]);
                i = size;
            }           
        }
    }
    
    /*
        This technique enables the user to look up every task that has been given to a specific developer.
    */
    public static void developerTasks(){
        String devNames;
        devNames = JOptionPane.showInputDialog("Please enter developer full names");
        
        for(int i = 0; i < size; i++){
            if(names[i].equals(devNames)){
                JOptionPane.showMessageDialog(null, taskNames[i] + ", " + statuses[i]);
            }
        }
        
    }
    /*
     The task will be destroyed along with all the information associated with it if the user enters a task that is already in the array.
    */
    public static void deleteTask(){
        String taskName;
        int deleteIndex; // This variable will contain the name of the deleted task.
        taskName = JOptionPane.showInputDialog("lease enter the name of the task to be deleted");
        /*
            The loop searches for the job that needs to be eliminated, and if it does, its index is noted and everything in the parallel arrays at that index is removed.
        */
        for(int i = 0; i < size; i++){
            
            if(taskNames[i].equals(taskName)){
               deleteIndex = i;
               
               JOptionPane.showMessageDialog(null, "Task " + taskNames[i] + " it was successfully deleted.");
               
                taskNames[deleteIndex] = "";
                
                names[deleteIndex] = "";
                
                IDs[deleteIndex] = "";
                
                statuses[deleteIndex] = "";
                
                durations[deleteIndex] = 0;
                
                i = size;
            }
                         
        }
    }
    public static void displayReport(){
        for(int i = 0; i < size; i++){
            JOptionPane.showMessageDialog(null, taskNames[i] + "\n"
                    +names[i]+ "\n"
                    + IDs[i] + "\n"
                    + statuses[i] +"\n"
                    + durations[i] + "\n");
        }
    }
}
 

