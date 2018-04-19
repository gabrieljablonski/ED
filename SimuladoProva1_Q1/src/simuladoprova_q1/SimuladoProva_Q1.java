package simuladoprova_q1;

import java.util.Scanner;

public class SimuladoProva_Q1 {

    public static void main(String[] args) {
        Pilha<Character> pilha = new Pilha();
        Scanner s = new Scanner(System.in);
        
        char[] expressao = s.nextLine().toCharArray();
        
        boolean indo = true;
        boolean errado = false;
        for(char c:expressao){
            if(c=='C') indo = false;
            else if(indo) pilha.push(c);
            else{
                if((char)pilha.topo.dado == c) pilha.pop();
                else{
                    errado = true;
                    break;
                }
            }
            
        }
        if(errado || !pilha.pilhaVazia()) System.out.println("Expressão NÃO é da forma xCy");
        else System.out.println("Expressão É da forma xCy");
        
    }
    
}
