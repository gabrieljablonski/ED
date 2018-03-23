package undoredo;

public class Stack {
    private int top;
    private Command[] command_stack;
    
    public Stack(){
        top = -1;
        command_stack = new Command[10];
    }
    
    public void push(Command command){
        if(isFull()){
            shift_left();
        }
        command_stack[++top] = command;
    }
    
    public void shift_left(){
        for(int i=0; i< top; i++){
            command_stack[i] = command_stack[i+1];
        }
        top--;
    }
    
    public Command top(){
        return command_stack[top];
    }
    
    public int current_size(){
        return top;
    }
    
    public Command pop(){
        return command_stack[top--];
    }
    
    public void clear(){
        top = -1;
    }
    
    public void print(){
        if (isEmpty()){
            System.out.println("Empty stack.");
            return;
        }
        for(int i = 0; i < top; i++){
            System.out.print(command_stack[i].type() + ", ");
        }
        System.out.println(command_stack[top].type() + ".");
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public boolean isFull(){
        return top == 9;
    }
}
