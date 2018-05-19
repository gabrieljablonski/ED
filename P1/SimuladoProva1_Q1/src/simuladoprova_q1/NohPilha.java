
package simuladoprova_q1;

public class NohPilha<T> extends Object {
    NohPilha prox;
    T dado;
    
    public NohPilha() {
        prox = null;
    }
    
    public NohPilha(T dado) { //com esse outro construtor consigo dar push no valor diretamente
        this.dado = dado;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NohPilha getProx() {
        return prox;
    }

    public void setProx(NohPilha prox) {
        this.prox = prox;
    }

}
