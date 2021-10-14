package dbc.company.exercicio07;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        Programa programa = new Programa(matriz);
        programa.verificar();

    }
}
