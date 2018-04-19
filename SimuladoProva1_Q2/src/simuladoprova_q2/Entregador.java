/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simuladoprova_q2;


public class Entregador {
    Pilha<Correspondencia> sacola;
    int quantidade_de_correspondencias;
    
    public Entregador(){
        this.sacola = new Pilha();
        this.quantidade_de_correspondencias = 0;
    }
    
    public void insereCorrespondencia(Correspondencia correspondencia){
        this.sacola.push(correspondencia);
        this.quantidade_de_correspondencias++;
    }
    
    public Correspondencia removeCorrespondencia(){
        this.quantidade_de_correspondencias--;
        return this.sacola.pop();
    }
    
    public boolean sacolaVazia(){
        return this.sacola.topo == null;
    }
    
    public Correspondencia proximaCorrespondencia(){
        return (Correspondencia)this.sacola.topo.dado;
    }
    
    public int faltaEntregar(){
        return this.quantidade_de_correspondencias;
    }
}
