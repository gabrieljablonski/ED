
package prova1_q2;

public class Pilha<T> extends Object { //extends Node?
    
    //public TAD[] pilha;
    NohPilha topo;
    
    public Pilha(){
        topo = null;
    }
    
    public boolean pilhaVazia(){
        return topo == null;
    }
    
    public void push(T valor){
        // Modificações feitas para a questão 2 da primeira prova
        // --------------------------------------------------------
        NohPilha checagem = this.topo;
        
        while(checagem != null){
            if(checagem.getDado() == valor) return;
            checagem = checagem.getProx();
        }
        // --------------------------------------------------------
        NohPilha novo = new NohPilha(); //ou Node novo = new Node(valor); - outro construtor
        novo.setDado(valor); //com o outro construtor não precisa dessa linha
        novo.setProx(topo);
        topo = novo;
    }
    
    public T pop(){
        T desempilhado; //auxiliar opcional - salva o ultimo topo para mostrar no main (opção 2)
        if (pilhaVazia()) {
            System.out.println("Pilha Vazia!");
            desempilhado = null;
        } else {
            desempilhado = (T) topo.getDado();
            topo = topo.getProx();
        }
        return desempilhado;
    }
    
    public void imprime(){
        if (pilhaVazia())
            System.out.println("A pilha esta vazia!");
        else {
            NohPilha p = topo;
            while (p != null){
                System.out.println(p.getDado().toString());
                p = p.getProx();
            }
        }
    }
    
    public int size(){
        NohPilha p = topo;
        int cont = 0;
        while (p != null){
            p = p.getProx();
            cont++;
        }
        return cont;
    }
    
    // Modificações feitas para a questão 2 da primeira prova
    // --------------------------------------------------------
    
    public Pilha invertida(){
        Pilha<T> pilha_invertida = new Pilha();
        Pilha<T> pilha_auxiliar = new Pilha();
        
        while(this.size() > 0){
            T dado = this.pop();
            pilha_invertida.push(dado);
            pilha_auxiliar.push(dado);
        }
        
        while(pilha_auxiliar.size() > 0){
            this.push(pilha_auxiliar.pop());
        }   
        return pilha_invertida;
    }
    
    public int tamanho(){
        Pilha<T> pilha_auxiliar = new Pilha();
        int t = 0;
        while(this.size() > 0){ 
            pilha_auxiliar.push(this.pop());
            t++;
        }
        while(pilha_auxiliar.size() > 0) this.push(pilha_auxiliar.pop());
        
        return t;
    }
    
    // --------------------------------------------------------
}
