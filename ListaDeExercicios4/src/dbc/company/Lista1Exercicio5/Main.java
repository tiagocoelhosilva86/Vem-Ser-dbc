package dbc.company.Lista1Exercicio5;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner (System.in);

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();

        System.out.println("digite o valor da hora trabalhada");
        funcionario.valorhora = input.nextFloat();

        System.out.println("digite quantidade de horas trabalhadas");
        funcionario.horastrabalhadas = input.nextFloat();

        System.out.println("digite horas extras 50% ");
        funcionario.horasextras = input.nextFloat();

        System.out.println("digite horas extras trabalhadas 100% ");
        funcionario.horastrabalhadas = input.nextFloat();

        funcionario.calcularsalario();

        System.out.println(funcionario.salario);

    }

}
