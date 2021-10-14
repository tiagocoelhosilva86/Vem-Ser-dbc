package dbc.company.exercicio08;

public class Main {
    public static void main(String[] args) {
        float[][] numeros = {
                {2,8,5,9},
                {9,2,8,7},
                {1,9,3,0},
                {4,3,7,0},
                {5,2,10,9},
        };

        Programa programa = new Programa(numeros);
        programa.media();

    }
}
