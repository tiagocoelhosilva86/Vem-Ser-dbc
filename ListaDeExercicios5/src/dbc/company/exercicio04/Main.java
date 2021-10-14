package dbc.company.exercicio04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = {11,5,3};

        for(int i = 1; i < numeros.length; i++){
           System.out.println("Digite o numero " );
           int numerosDigitados = scanner.nextInt();
        numeros[i] = numerosDigitados;
       }
        Programa programa = new Programa(numeros);
        programa.imprime();


    }
}
