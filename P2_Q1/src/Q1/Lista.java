package Q1;

public class Lista {

    private NohLista inicio;
    private NohLista fim;
    private int qtdeElementos = 0;

    public Lista() {
        inicio = fim = null;
    }

    public boolean listaVazia() {
        return inicio == null;
    }

    public void insereInicio(int e) {
        NohLista novo = new NohLista(e);
        if (listaVazia()) {
            inicio = fim = novo;
        } else {
            inicio.setAnterior(novo);
            novo.setProximo(inicio);
            inicio = novo;
        }
        qtdeElementos++;
    }

    public void insereFim(int e) {
        NohLista novo = new NohLista(e);
        if (listaVazia()) {
            inicio = fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
        qtdeElementos++;
    }

    // Imprime da esquerda para a direita
    public void imprimeDireita() {
        if (listaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        NohLista corrente = inicio;
        while (corrente != null) {
            System.out.print(corrente.getDado() + " ");
            corrente = corrente.getProximo();
        }
        System.out.println();
    }

    // Imprime da direita para a esquerda
    public void imprimeEsquerda() {
        if (listaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        NohLista corrente = fim;
        while (corrente != null) {
            System.out.print(corrente.getDado() + " ");
            corrente = corrente.getAnterior();
        }
        System.out.println();
    }

    public void contaElementos() {
        System.out.println("A lista tem " + qtdeElementos + " elementos.");
    }

    // Remove um elemento 'e'
    public void remove(int e) {
        if (listaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        if (inicio.getDado() == e) {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
            System.out.println("Elemento removido: " + e);
            qtdeElementos--;
        } else if (fim.getDado() == e) {
            fim = fim.getAnterior();
            fim.setProximo(null);
            System.out.println("Elemento removido: " + e);
            qtdeElementos--;
        } else {
            NohLista n = inicio;
            while (n != null && n.getDado() != e) {
                n = n.getProximo();
            }
            if (n == null) {
                System.out.println("Elemento não encontrado!");
            } else {
                n.getAnterior().setProximo(n.getProximo());
                n.getProximo().setAnterior(n.getAnterior());
                System.out.println("Elemento removido: " + e);
                qtdeElementos--;
            }
        }
    }

    // Insere um elemento 'e' antes de um elemento 'eLista'
    public void insereAntes(int e, int eLista) {
        NohLista novo = new NohLista(e);
        if (inicio.getDado() == eLista) {
            inicio.setAnterior(novo);
            novo.setProximo(inicio);
            inicio = novo;
            qtdeElementos++;
        } else {
            NohLista atual = inicio;
            while (atual != null && atual.getDado() != eLista) {
                atual = atual.getProximo();
            }
            if (atual == null) {
                System.out.println("Elemento não encontrado!");
            } else {
                novo.setProximo(atual);
                novo.setAnterior(atual.getAnterior());
                atual.setAnterior(novo);
                novo.getAnterior().setProximo(novo);
                qtdeElementos++;
            }
        }
    }

    // Insere um elemento 'e' depois de um elemento 'eLista'
    public void insereDepois(int e, int eLista) {
        NohLista novo = new NohLista(e);
        if (fim.getDado() == eLista) {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
            qtdeElementos++;
        } else {
            NohLista atual = inicio;
            while (atual != null && atual.getDado() != eLista) {
                atual = atual.getProximo();
            }
            if (atual == null) {
                System.out.println("Elemento não encontrado!");
            } else {
                novo.setProximo(atual.getProximo());
                novo.setAnterior(atual);
                atual.setProximo(novo);
                novo.getProximo().setAnterior(novo);
                qtdeElementos++;
            }
        }
    }
    
    // Encontra a posição de um elemento 'e' (passando da esquerda para a direita)
    public void encontraPorElemento(int e) {
        NohLista n = inicio;
        int i = 1;
        while (n != null && n.getDado() != e) {
            n = n.getProximo();
            i++;
        }
        if (n == null) {
            System.out.println("Elemento não encontrado!");
        } else {
            System.out.println("Elemento " + e + " na posição " + i);
        }
    }
    
    /////////////////////////////////////////////
    
    public void insereCrescente(int e){
        if(this.listaVazia()){
            this.inicio = this.fim = new NohLista(e);
            this.qtdeElementos++;
        }
        else{
            NohLista atual = this.inicio;
            while(atual != null && e > atual.getDado()){
                atual = atual.getProximo();
            }
            
            if(atual != null) this.insereAntes(e, atual.getDado());
            else this.insereFim(e);
        }
    }
  
    public int removePosicao(int posicao){
        int elemento_removido = -1;
        if(this.listaVazia()) return -1; // Assumindo lista somente com inteiros positivos
        else if(posicao == 0 && this.qtdeElementos == 1){
            elemento_removido = this.inicio.getDado();
            this.inicio = this.fim = null;
        }
        else if(posicao == 0){
            elemento_removido = this.inicio.getDado();
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(null);
        }
        else if(posicao == this.qtdeElementos - 1)
        {
            elemento_removido = this.fim.getDado();
            this.fim = this.fim.getAnterior();
            this.fim.setProximo(null);
        }
        else{
            NohLista el_atual = this.inicio.getProximo();
            int pos_atual = 1;
            
            while(pos_atual < posicao && pos_atual < this.qtdeElementos){
                el_atual = el_atual.getProximo();
                pos_atual++;
            }
            
            if(pos_atual == this.qtdeElementos) return -1;
            else{
                elemento_removido = el_atual.getDado();
                NohLista anterior = el_atual.getAnterior();
                NohLista proximo = el_atual.getProximo();
                
                proximo.setAnterior(anterior);
                anterior.setProximo(proximo);
            }
        }
        if(elemento_removido != -1) this.qtdeElementos--;
        return elemento_removido;
    }
    
    public void imprimeEsquerda_Direita(){
        if(this.listaVazia()) System.out.println("Lista vazia.\n");
        
        else{
            NohLista atual = this.inicio;
            
            System.out.print("Elementos na lista:\n>>");
            while(atual != null){
                System.out.print(" " + atual.getDado());
                atual = atual.getProximo();
            }
            System.out.println("\n");
        }
    }
}
