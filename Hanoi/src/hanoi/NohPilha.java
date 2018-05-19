/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoi;


public class NohPilha {
    private int dado;
    private NohPilha anterior;
    
    public NohPilha(int dado){
        this.dado = dado;
        this.anterior = null;
    }
    
    public int getDado(){
        return this.dado;
    }
    
    public NohPilha getAnterior(){
        return this.anterior;
    }
    
    public void setAnterior(NohPilha anterior){
        this.anterior = anterior;
    }
    
}
