
package simuladoprova_q2;

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
    
}
