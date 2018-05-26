
package arvorebin_buscaext;

import java.util.LinkedList;

public class ArvoreBin {
    private NohArvore raiz;
    
    public boolean isEmpty(){
        return raiz == null;
    }
   
    public void insere(int dado){
        insere(raiz, dado);
    }
    
    private void insere(NohArvore node, int dado){
        if (isEmpty()) {
            raiz = new NohArvore(dado);
        } else {
            if (dado < node.getDado()) {
                if (node.getNohEsquerdo() != null) {
                    insere(node.getNohEsquerdo(), dado);
                } else {
                    node.setNohEsquerdo(new NohArvore(dado));
                }
            } else if (dado > node.getDado()){
                if (node.getNohDireito() != null) {
                    insere(node.getNohDireito(), dado);
                } else {
                    node.setNohDireito(new NohArvore(dado));
                }
            }
        }
    }
    
    public void percorreExtensao(){
        LinkedList<NohArvore> arvore_extenso = new LinkedList<>();
        arvore_extenso.addLast(this.raiz);
        arvore_extenso.addLast(null);
        
        if(this.isEmpty()) System.out.println("Arvore vazia");
        
        else this.percorreExtensao(arvore_extenso);
    }
    
    private void percorreExtensao(LinkedList<NohArvore> arvore_extenso){
        NohArvore node = arvore_extenso.removeFirst();
        
        if(node == null){
            arvore_extenso.addLast(null);
            node = arvore_extenso.removeFirst();
           
            if(node != null) System.out.print(" - ");
            else{
                System.out.println();
                return;
            }
        }
                
        NohArvore esquerdo = node.getNohEsquerdo();
        NohArvore direito = node.getNohDireito();

        System.out.print(node.getDado() + " ");

        if(esquerdo != null) arvore_extenso.addLast(esquerdo);
        if(direito != null) arvore_extenso.addLast(direito);
        
        if(!arvore_extenso.isEmpty()) this.percorreExtensao(arvore_extenso);
        else System.out.println();
    }
    
    public int tamanho(){
        if(this.isEmpty()) return 0;
        
        else return this.tamanho(this.raiz, 1);
    }
    
    private int tamanho(NohArvore node, int t){
        
        if(node == null) return t;
        
        NohArvore direito = node.getNohDireito();
        NohArvore esquerdo = node.getNohEsquerdo();
        
        if(direito != null) t++;
        if(esquerdo != null) t++;
        
        t = this.tamanho(esquerdo, t);
        t = this.tamanho(direito, t);
        
        return t;
    }
    
    public int altura(){
        if(this.isEmpty()) return 0;
        
        else return this.altura(this.raiz, 1);
    }
    
    private int altura(NohArvore node, int h){
        if(node == null) return h;
        
        NohArvore direito = node.getNohDireito();
        NohArvore esquerdo = node.getNohEsquerdo();
        
        if(direito != null || esquerdo != null) h++;
        
        int hd = this.altura(direito, h);
        int he = this.altura(esquerdo, h);
        
        return (hd>he)? hd:he;
    }
    
    public int folhas(){
        if(this.isEmpty()) return 0;
        
        else return this.folhas(this.raiz, 0);
    }
    
    private int folhas(NohArvore node, int f){
        if(node == null) return f;
        
        NohArvore direito = node.getNohDireito();
        NohArvore esquerdo = node.getNohEsquerdo();
        
        if(direito == null && esquerdo == null) f++;
        
        else{
            f = this.folhas(esquerdo, f);
            f = this.folhas(direito, f);
        }
        
        return f;
    }
}
