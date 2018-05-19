package simuladoprova_q2;

import java.util.Scanner;

public class SimuladoProva_Q2 {

    public static void main(String[] args) {
        Entregador entregador = new Entregador();
        Scanner s = new Scanner(System.in);
        int n = 1;
        while(true){
            int option = s.nextInt();
            /*
            1 -> Insere na sacola
            2 -> Remove da sacola
            3 -> Vê se sacola está vazia
            4 -> Próxima correspondência
            5 -> Quantas faltam
            */
            switch(option){
                case 1:
                    entregador.insereCorrespondencia(
                            new Correspondencia("correspondência " + n));
                    System.out.println("Inseriu correspondência " + n++);
                    break;
                case 2:
                    Correspondencia removida = entregador.removeCorrespondencia();
                    System.out.println("Removeu " + removida.dados_da_correspondencia);
                    break;
                case 3:
                    if(entregador.sacolaVazia()) System.out.println("Sacola está vazia.");
                    else System.out.println("Sacola não está vazia.");
                    break;
                case 4:
                    System.out.println("Próxima correspondência: " +
                            entregador.proximaCorrespondencia().dados_da_correspondencia);
                    break;
                case 5:
                    System.out.println("Correspondências a entregar: " + entregador.quantidade_de_correspondencias);
                
            }
        }
    }
    
}
