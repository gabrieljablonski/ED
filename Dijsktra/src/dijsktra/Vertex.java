/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijsktra;


public class Vertex {
    private final String label;
    
    public Vertex(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
