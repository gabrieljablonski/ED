/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;


/**
 *
 * @author gabri
 */
public class Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista_encadeada = new Lista();
        Utilidade ut = new Utilidade();
        
        
        while(true){
            ut.menu();
            int op = ut.entraInteiro();
            if(op == 4) break;
            switch(op){
                case 1:
                    System.out.print("Selecione um elemento para inserir:\n>>");
                    int elemento = ut.entraInteiro();
                    lista_encadeada.insereCrescente(elemento);
                    break;
                case 2:
                    System.out.print("Selecione posição para remover:\n>>");
                    int posicao = ut.entraInteiro();
                    System.out.println(lista_encadeada.removePosicao(posicao));
                    break;
                case 3:
                    System.out.println("Lista da esquerda para direita:");
                    lista_encadeada.imprimeEsquerda_Direita();
                    break;
            }
        }
        
    }
    
}
