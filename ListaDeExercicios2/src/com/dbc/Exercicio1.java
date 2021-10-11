package com.dbc;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um produto:");
        String produto = in.nextLine();
        System.out.println("digite o Valor");
        float Valorproduto = in.nextFloat();
        float desconto = 0.05f;
        float caldesc;
        float ValorComdesconto;
        float ValorTotalComDesconto;

        for (int quantidade = 0; quantidade<10; quantidade++ ){
            caldesc = Valorproduto * desconto;
            ValorComdesconto = Valorproduto -desconto;
            ValorTotalComDesconto = ValorComdesconto * (quantidade + 1);
            desconto +=0.05f;
            System.out.println((quantidade + 1) +"R$" + String.format("%.2f",ValorComdesconto) + "=" + String.format("%.2f",ValorComdesconto));
        }





    }
}
