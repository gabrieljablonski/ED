package prova1_q1;

public class Prova1_Q1 {
    public static void main(String[] args) {
        Robo robo = new Robo();
        
        robo.colocaPeca("Cúpula");    // posicao 0
        robo.colocaPeca("Lâmpada");   // posicao 1
        robo.colocaPeca("Hélice 1");  // posicao 2
        robo.colocaPeca("Hélice 2");  // posicao 3
        robo.colocaPeca("Hélice 3");  // posicao 4
        robo.colocaPeca("Suporte");   // posicao 5
        
        robo.pecas.imprime();
        
        System.out.println();
     
        robo.substituiPeca(1, "Nova Lâmpada");
        robo.substituiPeca(2, "Nova Hélice 1");
        robo.substituiPeca(5, "Novo Suporte");
        
        robo.pecas.imprime();
    }
    
}
