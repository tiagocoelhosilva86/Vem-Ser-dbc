package com.dbc;
import java.util.Scanner;

public class Exercico5 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String valor;
        int v;

        final int i = 5;
        String vetor [] = new String[5];

        for  (v = 0;v < vetor.length;v++){
            System.out.println("digite um numero");
            valor = scanner.next();
            vetor[v] = valor;
        }
        for (v = vetor.length - 1; v >= 0;v--) {
                 System.out.println(vetor[v]);
        }
    }
}
