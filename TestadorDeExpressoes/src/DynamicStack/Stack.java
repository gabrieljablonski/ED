/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicStack;


public class Stack<T> extends Object {
    private StackNode top;
    
    public Stack(){
        this.top = null;
    }
    
    public boolean is_empty(){
        return this.top == null;
    }
    
    public void push(T value){
        this.top = new StackNode(value, this.top);
    }
    
    public T top() throws java.lang.RuntimeException{
        if(this.top==null) throw new RuntimeException("Empty stack");
        
        return (T)this.top.get_value();
    }
    
    public T pop() throws java.lang.RuntimeException{
        if(this.is_empty()) throw new java.lang.RuntimeException("Empty stack");
        
        StackNode last_top = this.top;        
        this.top = last_top.get_pNode();
        return (T)last_top.get_value();
    }
    
    public void clear(){
        while(top!=null) this.pop();
    }
    
    // Returns string with the values on the stack separated by EOL
    public String stack_as_string(){
        String stuff_on_stack = "";
        StackNode current_top = this.top;
        while(current_top != null){
            stuff_on_stack += current_top.get_value().toString() + "\n";
        }
        return stuff_on_stack;
    }
}
