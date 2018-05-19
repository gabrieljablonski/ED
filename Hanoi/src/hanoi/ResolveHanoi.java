/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoi;


public class ResolveHanoi {
    
    private int tamanho_torre;
    private Pilha torre_origem;
    private Pilha torre_extra;
    private Pilha torre_destino;
    
    public ResolveHanoi(int tamanho_torre){
        this.tamanho_torre = tamanho_torre;
        this.torre_destino = new Pilha();
        this.torre_extra = new Pilha();
        this.torre_origem = new Pilha();
    }
    
    public void resolve(){
        for(int i=this.tamanho_torre; i>0; i--){
            this.torre_origem.push(i);
        }
        this._resolve(this.tamanho_torre, this.torre_origem, 
                      this.torre_destino, this.torre_extra);
    }
    
    private void _resolve(int discos, Pilha torre_origem, 
                          Pilha torre_destino, Pilha torre_extra){
        if(discos == 1){
            torre_destino.push(torre_origem.pop());
            imprimeTorres();
        }
        else{
            this._resolve(discos - 1, torre_origem, torre_extra, torre_destino);
            torre_destino.push(torre_origem.pop());
            imprimeTorres();
            this._resolve(discos - 1, torre_extra, torre_destino, torre_origem);
        }
    }
    
    private void imprimeTorres(){
            System.out.print("Torre origem:  ");
            this.torre_origem.imprime();
            System.out.println();
            System.out.print("Torre extra:   ");
            this.torre_extra.imprime();
            System.out.println();
            System.out.print("Torre destino: ");
            this.torre_destino.imprime();
            System.out.println();
            System.out.println();
    }
    
}
