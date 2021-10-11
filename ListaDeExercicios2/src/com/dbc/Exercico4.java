package com.dbc;
import java.util.Scanner;

public class Exercico4 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int [] vetor = new int[3];
        int numero = 0;
        int p;

        for (p =0; p < 3; p++){
            System.out.println("digite um numero");
            vetor[p] = numero;
            numero = scanner.nextInt();
        }
        if (vetor[0] < vetor[1] && vetor[0] < vetor[2]){
            System.out.println("menor valor esta na posição 1:");
        }else if (vetor[1] < vetor[0] && vetor[1] < vetor[2]){
            System.out.println("menor valor esta na posição 2:");
        }else if (vetor[2] < vetor[0] && vetor[2] < vetor[1]){
            System.out.println("menor valor esta na posição 3:");
        }
    }

}
