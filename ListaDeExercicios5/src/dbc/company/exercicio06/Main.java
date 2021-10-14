package dbc.company.exercicio06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = {2,6,8,10,12,14,16,18,20,22};

        System.out.println("Digite um numero: ");
        int numeroEscolhido = scanner.nextInt();

        Programa programa = new Programa(numeros);
        programa.verificaNumero(numeroEscolhido);

    }
}
