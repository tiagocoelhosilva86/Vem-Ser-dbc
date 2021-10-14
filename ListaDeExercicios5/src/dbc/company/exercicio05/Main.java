package dbc.company.exercicio05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = {1,2,3,4,5,6};
        Programa programa = new Programa(numeros);
        programa.imprimeInvertido();

    }
}
