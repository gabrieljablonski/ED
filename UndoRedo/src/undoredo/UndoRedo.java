package undoredo;
import java.util.Scanner;

public class UndoRedo {
    
    int number_of_commands = 0;
    Stack undoStack = new Stack();
    Stack redoStack = new Stack();

    public static void main(String[] args) {
        
        
        UndoRedo commands = new UndoRedo();
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Choose an option:\n0-Quit\n1-Run command\n" +
                         "2-Undo last command\n3-Redo command\n" +
                         "4-Print command stacks\n>>");
        
        int option = input.nextInt();
        
        while (option != 0){
            commands.menu(option);
            System.out.print(">>");
            option = input.nextInt();
        }
        
    }
    
    private void menu(int option){
        switch(option){
            case 1:
                runCommand();
                break;
            case 2:
                undoCommand();
                break;
            case 3:
                redoCommand();
                break;
            case 4:
                System.out.println("Redo stack:");
                redoStack.print();
                System.out.println("Undo stack:");
                undoStack.print();
                break;
            default:
                System.out.println("Invalid command");
                break;    
        }   
    }
    
    private void runCommand(){
        undoStack.push(new Command(number_of_commands));
        number_of_commands++;
        undoStack.top().run();
        redoStack.clear();
    }
    
    private void undoCommand(){
        if (!undoStack.isEmpty()){
            Command undo_command = undoStack.pop();
            redoStack.push(undo_command);
            undo_command.undo();
            return;
        }
        System.out.println("No commands to undo.");
    }
    
    private void redoCommand(){
        if (!redoStack.isEmpty()){
            Command redo_command = redoStack.pop();
            undoStack.push(redo_command);
            System.out.println("//Redo");
            redo_command.run();
            return;
        }
        System.out.println("No commands to redo.");
    }
    
}
