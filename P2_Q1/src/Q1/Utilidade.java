/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Q1;

import java.util.Scanner;


public class Utilidade {
    Scanner s = new Scanner(System.in);
    public void menu(){
        System.out.println("Selecionar opção:");
        System.out.println("1-Inserir elemento em ordem crescente");
        System.out.println("2-Remover elemento em uma posição");
        System.out.println("3-Imprimir lista");
        System.out.print("4-Sair\n>>");
    }
    
    public int entraInteiro(){
        return this.s.nextInt();
    }
}
