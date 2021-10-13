package com.dbc;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("digite sua primeira ");
        int nota1 = in.nextInt();

        System.out.println("digite sua segunda ");
        int nota2 = in.nextInt();

        System.out.println("digite sua terçeira ");
        int nota3 = in.nextInt();

        System.out.println("digite sua quarta ");
        int nota4 = in.nextInt();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        System.out.println(media);


        if (media <= 5) {
            System.out.println("reprovado");

        } else if (media > 5 && media <7) {
            System.out.println("em exame");

        } else if (media > 7 && media <10) {
            System.out.println("aprovado");

        }
    }

}
