package dbc.company.exercicio06;

public class Programa {
    private int[] vetor;

    Programa(int[] vetor){this.vetor = vetor;}

    public void verificaNumero(int numero){
        int auxiliar = 0;
        for(int valor : vetor){
            if(valor == numero){
                auxiliar += 1;
            }
        }
        String mensagem = auxiliar > 0 ? "Existe  no vetor! e apareceu " + auxiliar + " vezes." : "Não apareceu.";
        System.out.println(mensagem);
    }

}
