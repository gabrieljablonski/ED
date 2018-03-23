package undoredo;

public class Command {
    
    private final int command_index;
    private final String command_type;
    
    public Command(int index){
        command_index = index;
        command_type = "Generic command " + (index+1);
    }
    
//    public Command(int index, String type){
//        command_index = index;
//        command_type = type;
//    }
    
    public int index(){
        return command_index;
    }
    
    public String type(){
        return command_type;
    }
    
    public void run(){
        System.out.print("Command " + (command_index + 1) + " (");
        System.out.print(command_type);
        System.out.println(") executed.");

    }
    
    public void undo(){
        System.out.print("Command " + (command_index + 1) + " (");
        System.out.print(command_type);
        System.out.println(") undone.");
    }
    
    
}
