package dbc.company.exercicio04;

public class Programa {
    private int[] vetor;
    static int[] listaAuxiliar = new int[2];

    Programa(int[] vetor){
        this.vetor = vetor;
    }

    public void imprime(){
        int[] lista = rodaPrograma();
        System.out.printf("O menor numero  é: %s\nE está na posição: %s",
                lista[0], lista[1]);
    }

    public int[] rodaPrograma(){
        int numeroMenor = 0;
        int posicao = 0;
        for (int i = 0; i < vetor.length; i++){
            int aux = 0;
            for (int y = 0; y < vetor.length; y++){
                if (vetor[i] < vetor[y] || vetor[i] == vetor[y]){
                    aux += 1;
                    if(aux == 3){
                        numeroMenor = vetor[i];
                        listaAuxiliar[0] = numeroMenor;
                    }
                }
            }
        }
        for (int i = 0; i < vetor.length; i++){
            if(numeroMenor == vetor[i]){
                posicao = i;
                listaAuxiliar[1] = posicao;
                break;
            }
        }
        return listaAuxiliar;
    }

}
