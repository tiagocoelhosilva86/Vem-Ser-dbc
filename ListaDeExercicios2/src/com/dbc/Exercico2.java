package com.dbc;
import java.util.Scanner;

public class Exercico2 {
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    int numeroescondido = 20;
    int numero;

    do {
        System.out.println("pista o numero estara entre 1 e 20 boa sorte!");
        System.out.println("digite um numero:");
        numero = scanner.nextInt();
        if (numero<numeroescondido){
            System.out.println("Errou,o numero escondido e maior que o digitado tente outra vez");
        }else  if (numero > numeroescondido){
            System.out.print("você errou o numero escondido e menor que o digitado tente outra vez");
        }
    }while (numero != numeroescondido);
    System.out.println("Parabens você acertou");

 }

}
