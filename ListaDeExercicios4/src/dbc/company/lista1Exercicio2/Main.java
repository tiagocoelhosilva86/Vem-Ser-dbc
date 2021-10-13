package dbc.company.lista1Exercicio2;
import dbc.company.lista1Exercicio2.Aluno;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner (System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno =new Aluno();

        System.out.println("digite sua primeira nota");
        aluno.nota1 = input.nextFloat();

        System.out.println("digite sua segunda  nota");
        aluno.nota2 = input.nextFloat();

        System.out.println("digite sua terceiro nota");
        aluno.nota3 = input.nextFloat();

        System.out.println("digite sua quarta nota");
        aluno.nota4 = input.nextFloat();

        aluno.calculaMedia();
        aluno.Resultado();

    }
}
