package dbc.company.exercicio08;

public class Programa {
    public float[][] matriz;

    Programa(float[][] matriz){this.matriz = matriz;}

    public void media(){
        float mediaFinal = 0;
        for (int i = 0; i < matriz.length; i++){
            for (int y = 0; y < matriz.length; y++){
                float media = (float) ((matriz[i][1] * 0.6) + (matriz[i][2] * 0.4));
                matriz[y][3] = media;
                mediaFinal +=  (media/ 5 ) /5 ;
            }
            System.out.printf("Média do %s° aluno = %s\n", (int) matriz[i][0], matriz[i][3]);
        }
        System.out.printf("Média das notas finais = %.2f", mediaFinal);
    }

}
