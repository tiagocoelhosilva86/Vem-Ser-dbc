package dbc.company.exercicio05;

public class Programa {
    public int[] vetor;

    Programa(int[] vetor){ this.vetor = vetor; }

    public void imprimeInvertido(){
        for(int i = vetor.length - 1; i >= 0; i--){
            System.out.println(vetor[i]);
        }
    }

}
