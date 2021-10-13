package dbc.company.Lista1Exercicio5;

   public class Funcionario {
   public double salario;
   public double valorhora;
   public double horastrabalhadas;
   public double horasextras;
   public double horasextrastrabalhadas;


    public void calcularsalario(){

        double valorhorastrabalhadas = (valorhora * horastrabalhadas );
        double valorhorasextras = (valorhora * 1.5) *  horasextras;
        double valorhorasesxtrastrabalhadas = (2 * valorhora) * horasextrastrabalhadas;
         salario = (valorhorastrabalhadas + valorhorasextras + valorhorasesxtrastrabalhadas);
    }
   }

