package com.dbc;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("digite o valor da hora trabalhada");
        double valorhora = in.nextInt();

        System.out.println("digite quantidade de horas trabalhadas");
        double horastrabalhadas = in.nextInt();

        System.out.println("digite horas extras 50% ");
        double horasextras = in.nextInt();

        System.out.println("digite horas extras trabalhadas 100% ");
        double  horasextrastrabalhadas = in.nextInt();

        double valorhorastrabalhadas = (valorhora * horastrabalhadas );
        double valorhorasextras = (valorhora * 1.5) *  horasextras;
        double valorhorasesxtrastrabalhadas = (2 * valorhora) * horasextrastrabalhadas;

        double salario = (valorhorastrabalhadas + valorhorasextras + valorhorasesxtrastrabalhadas);
        System.out.println("R$"+salario);

    }
}
