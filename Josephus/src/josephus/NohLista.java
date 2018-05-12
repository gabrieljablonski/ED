package josephus;

public class NohLista {
    
    private NohLista anterior;
    private NohLista proximo;
    private String dado;
    
    public NohLista(String dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
    
    public NohLista getAnterior(){
        return this.anterior;
    }
    
    public void setAnterior(NohLista anterior){
        this.anterior = anterior;
    }
    
    public NohLista getProximo(){
        return this.proximo;
    }
    
    public void setProximo(NohLista proximo){
        this.proximo = proximo;
    }
    
    public String getDado(){
        return this.dado;
    }
    
    public void setDado(String dado){
        this.dado = dado;
    }
  
}
