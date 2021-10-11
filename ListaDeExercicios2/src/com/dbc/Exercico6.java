package com.dbc;

import java.util.Scanner;

public class Exercico6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int Vetor [] ={1,2,3,4,5,6,7,8,9,10};
        int n;

        System.out.println("digite um valor:");
        int numero = scanner.nextInt();
        boolean encontrou = false;


        for (n = 0; n < Vetor.length; n++) {
            if (Vetor[n] == numero) {
                encontrou = true;
            }
        }
        if (encontrou) {
            System.out.println("numero" + numero + "esta no vetor");
        } else {
            System.out.println("esse numero não existe" + numero + "vetor");

        }
    }
}
