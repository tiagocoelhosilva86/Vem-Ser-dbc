package com.dbc;

import java.util.Objects;
import java.util.Scanner;

public class Exercico3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String nome = "";
        Float altura;
        int idade;
        float peso;
        int quantidadejogadores = 0;
        float maioraltura = 0;
        String jogadorMaisVelho = "";
        int maioridade =0;
        float maisPesado = 0;
        String jogadorMaisPesado  = "";
        float mediaalturasjogador = 0;

        System.out.println("responda o questionario a seguir ão terminar (Sim) para sair da pesquisa");
        System.out.println("qual seu nome?");
        nome = scanner.next();

        while (!Objects.equals (nome,"sair")){

            System.out.println("qual sua altura");
            altura = scanner.nextFloat();
            if (altura > maioraltura){
                maioraltura = altura;
            }
            maioraltura += altura;

            System.out.println("qual sua idade?");
            idade = scanner.nextInt();
            if (idade > maioridade){
                maioridade = idade;
                 jogadorMaisVelho = nome;
            }

            System.out.println("qual seu peso ");
            peso = scanner.nextFloat();
            if (peso > maisPesado){
                maisPesado = peso;
                jogadorMaisPesado = nome;
            }
            System.out.println("qual seu nome ?(sair) para finalizar");
            nome = scanner.next();
            quantidadejogadores += 1;
        }
        System.out.println("quantidade de jogadores cadastrado:" + quantidadejogadores);
        System.out.println("altura do maior jigador:" + maioraltura);
        System.out.println("jogador mais pesado:" + jogadorMaisPesado);
        System.out.println("jogador mais velho:" + jogadorMaisVelho);
        System.out.println("media alturas:" + mediaalturasjogador);
    }

}
