package com.dbc;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("digite um  nome a seguir para tradução ");
        String nome = in.next();

        if (nome.equals("Cachorro")){
            System.out.println("Dog");
        }else if (nome.equals( "Dog")) {
            System.out.println("Cachorro");
        }else if (nome.equals("Tempo")){
                System.out.println("Time");
            }else if (nome.equals("Time")) {
            System.out.println("Tempo");
        }else if (nome.equals("Amor")){
                System.out.println("Love");
            }else  if (nome.equals("Love")) {
            System.out.println("Amor");
        }else if (nome.equals("Cidade")){
                System.out.println("City");
            }else  if (nome.equals("City")) {
            System.out.println("Cidade");
        }else if (nome.equals("Feliz")){
                System.out.println("Happy");
            }else if (nome.equals("Happy" )) {
            System.out.println("Feliz");
        }else {
            System.out.println("Essa palavra não é valida");
        }





        }




    }
