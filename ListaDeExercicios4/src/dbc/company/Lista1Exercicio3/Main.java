package dbc.company.Lista1Exercicio3;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner (System.in);

    public static void main(String[] args) {
        Caixa  caixa = new Caixa();

        System.out.println("digite valor total da conta");
        caixa.valordaconta = input.nextFloat();

        System.out.println("digite o valor pago");
        caixa.valorpago = input.nextFloat();


        caixa.calculartroco();


    }
}
