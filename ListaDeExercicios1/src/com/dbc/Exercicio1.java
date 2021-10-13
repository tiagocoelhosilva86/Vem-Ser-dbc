package com.dbc;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        String nome = in.nextLine();

        System.out.println("informe sua idade: ");
        int idade = in.nextInt();

        System.out.println("informe a sua cidade: ");
        String cidade = in.next();

        System.out.println("digite seu estado: ");
        String estado = in.next();

        System.out.println("Olá seu nome é " + nome);
        System.out.println("você tem "+ idade);
        System.out.println("é da cidade de "+ cidade);
        System.out.println("situada no estado de "+ estado);

    }



}
