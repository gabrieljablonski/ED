package prova1_q1;


public class Robo {
    Pilha<String> pecas;
    
    public Robo(){
        this.pecas = new Pilha();
    }
    
    public void colocaPeca(String peca){
        this.pecas.push(peca);
    }
    
    public void retiraPeca(){
        this.pecas.pop();
    }
    
    public void substituiPeca(int posicao, String nova_peca){
        this.pecas.substituiElemento(posicao, nova_peca);
    }
}
