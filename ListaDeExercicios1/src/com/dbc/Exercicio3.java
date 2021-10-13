package com.dbc;
import java.util.Scanner;


public class Exercicio3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("digite o valor total consumido");
        int valortotal = in.nextInt();

        System.out.println("digite valor pago");
        int valorpago = in.nextInt();

        if (valorpago<valortotal){
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");

        } else {
            int troco = (valorpago - valortotal);
            System.out.println("troco R$" + troco);
        }




    }
}
