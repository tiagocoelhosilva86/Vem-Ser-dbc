package dbc.company.exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Main jogo = new Main();
        jogo.jogo();
    }

    public void jogo(){
        Scanner scanner = new Scanner(System.in);
        final int numeroEscondido = 8;

        boolean auxiliar = true;
        while (auxiliar){
            try {
                while (true){
                    System.out.println("Digite um numero:");
                    int numero = scanner.nextInt();
                    try {
                        if(numero == numeroEscondido){
                            System.out.println("Parabéns, você acertou!");
                            auxiliar = false;
                            break;
                        }else {
                            System.err.println("Você errou!!!");
                            String aux = numero > numeroEscondido ? "Seu numero é maior!" : "Seu numero é menor";
                            System.out.println(aux);
                        }
                    }catch (Exception e){
                        System.err.println("ERRO");
                        break;
                    }
                }
            }catch (Exception e){
                System.err.println("ERRO");
                break;

            }
        }
    }
}
