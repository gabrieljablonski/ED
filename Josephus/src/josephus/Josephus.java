package josephus;

import java.util.Scanner;

public class Josephus {
    
    Lista soldados = new Lista();

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        Scanner s = new Scanner(System.in);
       
        josephus.soldados.insere("Josephus");  
        josephus.soldados.insere("Joao");
        josephus.soldados.insere("Pedro");
        josephus.soldados.insere("Claudio");
        josephus.soldados.insere("Lucas");
        josephus.soldados.insere("Felipe");
        josephus.soldados.insere("Fabio");
        josephus.soldados.insere("Fulano");
        josephus.soldados.insere("Cicrano");
        josephus.soldados.insere("Beltrano");
        
//        josephus.remove("Josephus", 0); // Joao, Pedro, Claudio, Lucas, Felipe, Fabio, Fulano, Cicrano, Beltrano
//        josephus.remove("Joao", 1);     // Joao, Claudio, Lucas, Felipe, Fabio, Fulano, Cicrano, Beltrano
//        josephus.remove("Claudio", 2);  // Joao, Claudio, Lucas, Fabio, Fulano, Cicrano, Beltrano
//        josephus.remove("Lucas", 3);    // Joao, Claudio, Lucas, Fabio, Fulano, Beltrano
//        josephus.remove("Fabio", -4);   // Joao, Claudio, Lucas, Fabio, Fulano
//        josephus.remove("Fulano", -5);  // Joao, Claudio, Lucas, Fabio
//        josephus.remove("Joao", -6);    // Joao, Claudio, Fabio
//        josephus.remove("Claudio", 9);  // Joao, Fabio
//        josephus.remove("Fabio", -9);   // Fabio

        while(josephus.soldados.getQtdElementos() > 1){
            
            System.out.println("Soldado sorteado:");
            String primeiro_soldado = s.nextLine();
            
            System.out.println("Número sorteado:");
            int elimina_posicao = s.nextInt(); s.nextLine();
            
            System.out.print("Eliminado: ");
            System.out.println(josephus.remove(primeiro_soldado, 
                                               elimina_posicao));
            System.out.println();
        }
        
        System.out.print("Soldado escolhido: ");
        josephus.soldados.imprime();
    }
    
    public String remove(String soldado, int elimina_posicao){
        NohLista c_soldado = this.soldados.encontra(soldado);
        int contagem = 0;
        while(contagem != elimina_posicao){
            if(elimina_posicao < 0){
                contagem--;
                c_soldado = c_soldado.getAnterior();
            }
            if(elimina_posicao > 0){
                contagem++;
                c_soldado = c_soldado.getProximo();
            }
            
        }
        this.soldados.remove(c_soldado.getDado());
        return c_soldado.getDado();
    }
}
