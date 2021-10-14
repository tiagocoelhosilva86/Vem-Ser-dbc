package dbc.company.exercicio07;

public class Programa {
    private int[][] matriz;

    Programa(int[][] matriz){this.matriz = matriz;}

    public void verificar(){
        int auxiliar = 0;
        for(int i = 0; i < matriz.length; i++){
            for(int y = 0; y < matriz.length; y++){
                int verifica = matriz[i][y] > 10 ? auxiliar += 1 : auxiliar;
            }
        }
        System.out.printf("Existem %s numeros maiores que 10 ", auxiliar);
    }

}
