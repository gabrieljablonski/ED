/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoi;


public class Pilha {
    
    private NohPilha topo;
    private int tamanho;
    
    public Pilha(){
        this.topo = null;
        this.tamanho = 0;
    }
    
    public void push(int n){
        NohPilha novo = new NohPilha(n);
        if(this.tamanho != 0){
            novo.setAnterior(this.topo);
        }
        this.topo = novo;
        this.tamanho++;
    }
    
    public int pop(){
        int p = this.topo.getDado();
        this.topo = this.topo.getAnterior();
        this.tamanho--;
        return p;
    }
    
    public void imprime(){
        this._imprime(this.topo);
    }
    
    private void _imprime(NohPilha t){
        if(t != null){
            _imprime(t.getAnterior());
            System.out.print(t.getDado() + " ");
        }
    }
    
}
