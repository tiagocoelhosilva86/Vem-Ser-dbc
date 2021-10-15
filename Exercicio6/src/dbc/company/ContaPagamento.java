package dbc.company;

public class ContaPagamento {
    public void setSaldo(double v) {
    }

    public Boolean sacar(double v) {
        return null;
    }

    public Double getSaldo() {
        return null;
    }

    public Boolean depositar(double v) {
        return null;
    }

    public static class contapagamento extends  Conta implements Impressao{
        private static final double Taxa_Saque = 4.25;

        public contapagamento(Cliente cliente, String numeroConta, int agencia, double saldo) {
            super(cliente, numeroConta, agencia, saldo);
        }

        public contapagamento() {

        }

        @Override
        public boolean sacar(double valor){
            return  super.sacar(valor + Taxa_Saque );
        }
        @Override
        public boolean transferir(Conta conta,double valor){
            boolean conseguiusacar = super.sacar(valor);
            boolean conseguiuDEpositar = false;
            if (conseguiusacar){
                conseguiuDEpositar = conta.depositar(valor);
            }
            return conseguiuDEpositar && conseguiusacar;
        }

        @Override
        public void imprimir() {
            System.out.println(this);
        }
    }
}
