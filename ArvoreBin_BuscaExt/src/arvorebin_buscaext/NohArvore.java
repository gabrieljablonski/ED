
package arvorebin_buscaext;

public class NohArvore {
    private NohArvore nohEsquerdo, nohDireito;
    private int dado;
    
    public NohArvore(int dadoNoh){
        dado = dadoNoh;
        nohEsquerdo = nohDireito = null;
    }

    public NohArvore getNohEsquerdo() {
        return nohEsquerdo;
    }

    public void setNohEsquerdo(NohArvore nohEsquerdo) {
        this.nohEsquerdo = nohEsquerdo;
    }

    public NohArvore getNohDireito() {
        return nohDireito;
    }

    public void setNohDireito(NohArvore nohDireito) {
        this.nohDireito = nohDireito;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }
    
}
