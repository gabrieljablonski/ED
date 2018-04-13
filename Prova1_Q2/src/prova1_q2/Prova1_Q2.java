package prova1_q2;

public class Prova1_Q2 {

    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha();
        for(int i=1; i<=5; i++) 
        {
            System.out.println("Tamanho da pilha: " + pilha.tamanho());
            pilha.push(i);
        }
        
        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        
        pilha.imprime();
        System.out.println();
        pilha.invertida().imprime();
        System.out.println();

        for(int i=0; i<10; i++) pilha.push(99); // tenta inserir 99 dez vezes
        
        pilha.imprime();
        
    }
    
}
