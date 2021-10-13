package com.dbc;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("escolha uma apoção:(Alagoas,Pernanbuco,Bahia) ");
        String opcao = in.nextLine();

        if (opcao.equals("Alagoas")){
            System.out.println("escolha:uma cidade(Maceio,Maragogi)");
            String cidade = in.nextLine();

            if (cidade.equals("Maceio")){
                System.out.println("Área: 509.552 km²" + "População:1,025 milhão (2020)");
            }else if(cidade.equals("Maragogi")){
                System.out.println("Área: 335 km²" + "População:33.032 (2020)");
            }
        }else if(opcao.equals("Pernanbuco")){
            System.out.println("escolha:uma cidade(Recife,Jaboatão dos Gararapes)");
            String cidade = in.nextLine();

            if (cidade.equals("Recife")){
                System.out.println("Área:218 km²" + "População:1,555 milhão ");
            }else if(cidade.equals("Jaboatão dos Gararapes")){
                System.out.println("Área:258.694 km²" + "População: 706.867");
            }
        }else if(opcao.equals("Bahia")){
            System.out.println("escolha:uma cidade(Ilheus,Porto Seguro)");
            String cidade = in.nextLine();

            if (cidade.equals("Ilheus")){
                System.out.println("Área:1.585 km² km²" + "População:159.923");
            }else if(cidade.equals("Porto Seguro")){
                System.out.println("Área:  2.287 km²" + "População:150.658");
            }
        }





    }

}
