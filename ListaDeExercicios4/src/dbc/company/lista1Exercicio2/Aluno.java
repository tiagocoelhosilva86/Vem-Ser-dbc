package dbc.company.lista1Exercicio2;

import java.util.Scanner;

public class Aluno {

    public float media;
    public float nota1,nota2,nota3,nota4;
    public String resultado;

    public void calculaMedia(){
        media = (nota1 + nota2 + nota3 + nota4) / 4;
    }

    public void Resultado(){

        if (media <= 5) {
            resultado ="reprovado";
            System.out.println("reprovado");

        } else if (media > 5 && media <7) {
            resultado ="em exame";
            System.out.println("em exame");

        } else if (media > 7 && media <10) {
            resultado ="aprovado";
            System.out.println("aprovado");

        }
    }


}
