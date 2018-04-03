package DoubleSidedStack;

import java.util.Scanner;

public class Main {
    
    DoubleSidedStack stack = new DoubleSidedStack();

    public static void main(String[] args) {
        Main main = new Main();
        
        Scanner input = new Scanner(System.in);
        
        int option;
        
        do{
            System.out.print("Choose an option:\n0-Quit\n1-Stack on left\n" +
                         "2-Stack on right\n3-Unstack on left\n" +
                         "4-Unstack on right\n5-Print array\n>>");
            option = input.nextInt();
            try
            {
                main.menu(option); 
            }
            catch(java.lang.RuntimeException e)
            {
                System.out.println(e);
            }
        }while (option != 0);
    }
    
    public void menu(int option)
    {   
        Scanner input = new Scanner(System.in);
        
        switch(option){
            case 0:
                break;
            case 1:
                System.out.print("Element to stack:\n>>");
                stack.push(1, input.nextInt());
                break;
            case 2:
                System.out.print("Element to stack:\n>>");
                stack.push(2, input.nextInt());
                break;
            case 3:
                System.out.println("Element unstacked: " + stack.pop(1));
                break;
            case 4:
                System.out.println("Element unstacked: " + stack.pop(2));
                break;
            case 5:
                stack.print_array();
                break;
            default:
                System.out.println("Invalid command");
                break;    
        }   
    }
    
    
}
