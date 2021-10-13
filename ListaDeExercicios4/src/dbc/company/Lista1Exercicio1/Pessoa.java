package dbc.company.Lista1Exercicio1;

import java.util.Scanner;

public class Pessoa {
    Scanner input = new Scanner (System.in);

    private String nome;
    private int idade;
    private String cidade;
    private String estado;

    public void dados(){
        System.out.println("diga seu nome");
        this.nome = input.nextLine();

        System.out.println("diga sua idade");
        this.idade = input.nextInt();
        input.nextLine();

        System.out.println("diga sua cidade");
        this.cidade = input.nextLine();

        System.out.println("diga seu estado");
        this.estado = input.nextLine();

        System.out.printf("ola meu nome e %s tenho %d moro na cidade  %s do estado %s",this.nome,this.idade,this.cidade,this.estado);



    }

}
