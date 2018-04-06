/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynamicStack;


public class StackNode<T> extends Object {
    private T value;
    private StackNode pNode;
    
    public StackNode(T value){
        this.value = value;
        this.pNode = null;
    }
    
    public StackNode(T value, StackNode pNode){
        this.value = value;
        this.pNode = pNode;
    }

    public T get_value() {
        return value;
    }

    public void set_value(T value) {
        this.value = value;
    }

    public StackNode get_pNode() {
        return pNode;
    }

    public void set_pNode(StackNode pNode) {
        this.pNode = pNode;
    }
    
    
}
