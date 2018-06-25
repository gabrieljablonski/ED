
package Q2;

public class Q2 {

    public static void main(String[] args) {
        ArvoreBin arvore = new ArvoreBin();
        
        arvore.insere(25);
        arvore.insere(20);
        arvore.insere(31);
        arvore.insere(11);
        arvore.insere(22);
        arvore.insere(29);
        arvore.insere(46);
        arvore.insere(8);
        arvore.insere(15);
        arvore.insere(43);
        arvore.insere(17);
        arvore.insere(26);
        System.out.println("\n");
        arvore.printPreOrder();
        System.out.println("\n");
        arvore.printPostOrder();
        System.out.println();
    }
    
}
