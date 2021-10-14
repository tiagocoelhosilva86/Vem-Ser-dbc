package dbc.company;

public class ContaCorrente extends  Conta implements Impressao{

    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        super( cliente,  numeroConta,  agencia,  saldo );

        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "Número da conta: " + getNumeroConta() + "\nAgência: " + getAgencia() + "\nSalto: " + getSaldo();
    }





    public double retornarSaldoComChequeEspecial() {

        return this.getSaldo() + chequeEspecial;
    }



    @Override
    public boolean sacar(double valor) {
        if (valor < (getSaldo() + chequeEspecial) && valor > 0) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;

    }

    @Override
    public void imprimir() {
        System.out.println("Número da conta: " + getNumeroConta() + "\nAgência: " + getAgencia() + "\nSalto: " + getSaldo());

    }
}
