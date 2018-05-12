package josephus;

public class Lista {

    private NohLista inicio;
    private NohLista fim;
    private int qtdElementos;
    
    public Lista(){
        this.inicio = null;
        this.fim = null;
        this.qtdElementos = 0;
    }
    
    public int getQtdElementos(){
        return this.qtdElementos;
    }
    
    public void insere(String e){
        NohLista novo = new NohLista(e);
        
        if(this.getQtdElementos() == 0){
            this.inicio = novo;
            this.fim = novo;
        }
        else{
            novo.setAnterior(this.fim);
            this.fim.setProximo(novo);
            this.fim = novo;
        }
        
        this.qtdElementos++;
       
        // Circularidade
        this.inicio.setAnterior(this.fim);
        this.fim.setProximo(this.inicio);
    }
    
    public void remove(String e){
        if(this.inicio.getDado().equals(e)){
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(this.fim);
            this.fim.setProximo(this.inicio);
        }
        else if(this.fim.getDado().equals(e)){
            this.fim = this.fim.getAnterior();
            this.fim.setProximo(this.inicio);
            this.inicio.setAnterior(this.fim);
        }
        else{
            int c_posicao = 1;
            NohLista remover = this.inicio.getProximo();

            while(!remover.getDado().equals(e) &&
                    c_posicao < this.getQtdElementos() - 1)
            {
                c_posicao++;
                remover = remover.getProximo();
            }

            if(c_posicao == this.getQtdElementos()) return;

            remover.getAnterior().setProximo(remover.getProximo());
            remover.getProximo().setAnterior(remover.getAnterior());
        }
        
        this.qtdElementos--;

    }
    
    public NohLista encontra(String e){
        int c_posicao = 0;
        NohLista encontrar = this.inicio;
        
        while(c_posicao != this.getQtdElementos() &&
                !encontrar.getDado().equals(e))
        {
            c_posicao++;
            encontrar = encontrar.getProximo();
        }
        
        return (c_posicao == this.getQtdElementos())? null: encontrar;
    }
    
    public void imprime(){
        int c_posicao = 0;
        NohLista c_noh = this.inicio;
        
        while(c_posicao != this.getQtdElementos()){
            System.out.println(c_noh.getDado());
            c_noh = c_noh.getProximo();
            c_posicao++;
        }
    }
}
