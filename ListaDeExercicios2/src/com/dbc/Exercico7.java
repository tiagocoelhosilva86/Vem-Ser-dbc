package com.dbc;

import java.util.Scanner;

public class Exercico7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        int matriz [][] = new int[4][4];

        matriz [0][0] = 2;
        matriz [0][1] = 4;
        matriz [0][2] = 6;
        matriz [0][3] = 8;
        matriz [1][0] = 10;
        matriz [1][1] = 3;
        matriz [1][2] = 5;
        matriz [1][3] = 7;
        matriz [1][2] = 9;
        matriz [1][3] = 11;
        matriz [2][0] = 12;
        matriz [2][1] = 13;
        matriz [2][2] = 14;
        matriz [2][3] = 15;
        matriz [3][1] = 16;
        matriz [3][1] = 17;
        matriz [3][2] = 18;


        int quantidade = 0;
        for (int a = 0; a < matriz.length; a++){
            for (int b = 0; b < matriz.length;b++){
                if (matriz[a][b] > 10){
                    quantidade += 1;
                }

            }
        }
         System.out.println("quantidade" + quantidade +" valores maiores que 10");




    }
}
