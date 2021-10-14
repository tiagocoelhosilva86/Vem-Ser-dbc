package dbc.company.exercicio03;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogadores jogador = new Jogadores();


        while (true){
            System.out.println("Digite o nome do jogador:  ");
            String nomeJogador = scanner.next();
            jogador.setNomeJogadores(nomeJogador);

            System.out.println("Digite a altura do jogador");
            Float alturaJogador = scanner.nextFloat();
            jogador.setAlturaJogadores(alturaJogador);

            System.out.println("Digite a idade do jogador: ");
            Integer idadeJogador = scanner.nextInt();
            jogador.setIdadeJogadores(idadeJogador);

            System.out.println("Digite o peso do jogador: ");
            Float pesoJogador = scanner.nextFloat();
            jogador.setPesoJogadores(pesoJogador);

            System.out.println("Deseja sair? [Sim/Não]");
            String verifica = scanner.next();

            if(verifica.toLowerCase(Locale.ROOT).equals("sim")){
                jogador.imprime();
                break;
            }


        }



    }


}
