package dbc.company.Lista1Exercicio3;

public class Caixa {
    public float valordaconta;
    public float valorpago;
    public float trocodocliente;

    public void calculartroco(){
        if (valorpago < valordaconta){
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");

        } else if (valorpago >= valordaconta){
            trocodocliente = (valorpago - valordaconta);
            System.out.println("troco R$"+ trocodocliente);
        }
    }




}
