package hanoi;

import java.util.Scanner;

public class Hanoi {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tamanho_torre;
        
        System.out.print("Tamanho da torre:\n>>");
        tamanho_torre = s.nextInt();
        
        System.out.println("Solução torre de " + tamanho_torre + " discos:\n");
        
        new ResolveHanoi(tamanho_torre).resolve();
        
    }
    
}
