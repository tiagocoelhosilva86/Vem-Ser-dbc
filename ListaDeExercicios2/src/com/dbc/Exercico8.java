package com.dbc;
import java.util.Scanner;

   public class Exercico8 {

       public static void main(String[]args){

           Scanner scanner = new Scanner(System.in);
           int [][] infoalunos = new int[5][4];
           double [] notafinal = new double[5];

           for(int i = 0; i < 5; i++) {
               System.out.print("digite o numero da sua matricula" + (i + 1) + ";");
               infoalunos[i][0] = scanner.nextInt();
               System.out.println("media das provas alunos" + (i + 1) + ":");
               infoalunos[i][1] = scanner.nextInt();
               System.out.println("media dos trabalhos do aluno" + (i + 1) + ":");
               infoalunos[i][2] = scanner.nextInt();
              }
               double somaNotasFinais = 0;
               for (int i = 0; i < 5; i++){
                   infoalunos[i][3] = (int) (infoalunos[i][1] * 0.6 + infoalunos[i][2] * 0.4);
                   somaNotasFinais += infoalunos[i][3];
               }
               int matriculaDaMaiornota = 0;
               double maioMedia = infoalunos[0][3];
               for (int i = 0; i < 5; i++){
                   if (maioMedia < infoalunos[i][3]){
                       maioMedia = infoalunos[i][3];
                       matriculaDaMaiornota = i;

                   }
               }
               System.out.println("resultado alunos");
               System.out.println("matricula com maior nota :" + infoalunos[matriculaDaMaiornota][0]);
               System.out.println("maior nota final:"+ maioMedia);
               System.out.println("media das notas finais:"+ somaNotasFinais/5);

           }
       }

