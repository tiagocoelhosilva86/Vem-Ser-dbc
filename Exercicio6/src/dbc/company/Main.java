package dbc.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente("tiago", "12345678910");

        Cliente cliente2 = new Cliente("diego","2829908722");


        ContaCorrente contatiago = new ContaCorrente(cliente1,"4986.2",48, 500,500);

        ContaCorrente contadiego = new ContaCorrente(cliente2,"121314",123,4000,600);

        boolean opcoesOk = true;
        while (opcoesOk) {
            System.out.println("Escolha uma conta para efetuar uma operação: ");
            System.out.println("1- " + cliente1.getNome());
            System.out.println("2- " + cliente2.getNome());
            int opcaoCliente = scanner.nextInt();
            System.out.println("Qual operação deseja realizar: \n1- Depositar \n2- Transferir \n3- Sacar \n4- Obter saldo total \n5- Imprimir dados da conta\n6-Sair");
            int opcaoDeTransacao = scanner.nextInt();

            switch (opcaoDeTransacao) {
                case 1:
                    System.out.println("Qual valor deseja depositar? ");
                    double valorDeposito = scanner.nextDouble();
                    if (opcaoCliente == 1 && contatiago.depositar(valorDeposito)) {
                        System.out.println("O saldo atual desta conta é: " + contatiago.getSaldo());
                    }
                    if (opcaoCliente == 1 && !contatiago.depositar(valorDeposito)) {
                        System.out.println("Não foi possível realizar essa operação!");
                    }
                    if (opcaoCliente == 2 && contadiego.depositar(valorDeposito)) {
                        System.out.println("O saldo atual desta conta é: " + contadiego.getSaldo());
                    }
                    if (opcaoCliente == 2 && !contadiego.depositar(valorDeposito)) {
                        System.out.println("Não foi possível realizar essa operação!");
                    }
                    break;
                case 2:
                    if (opcaoCliente == 1) {
                        System.out.println("Deseja transferir para " + cliente2.getNome() + " \n1- sim \n2- não");
                        int opcaoConfirma = scanner.nextInt();
                        if (opcaoConfirma == 2) {
                            break;
                        }
                        if (opcaoConfirma == 1) {
                            System.out.println("Digite a quantia a ser transferida: ");
                            double valorTransferencia = scanner.nextDouble();
                            if (contatiago.transferir(contadiego, valorTransferencia)) {
                                System.out.println("O novo saldo de diego é: " + contadiego.getSaldo());
                            }
                            else {
                                System.out.println("Não foi possível realizar a transferência");
                            }
                        }
                    }
                    if (opcaoCliente == 2) {
                        System.out.println("Deseja transferir para " + cliente1.getNome() + " \n1- sim \n2- não");
                        int opcaoConfirma = scanner.nextInt();
                        if (opcaoConfirma == 2) {
                            break;
                        }
                        if (opcaoConfirma == 1) {
                            System.out.println("Digite a quantia a ser transferida: ");
                            double valorTransferencia = scanner.nextDouble();
                            if (contadiego.transferir(contatiago, valorTransferencia)) {
                                System.out.println("O novo saldo de tiago é: " + contatiago.getSaldo());
                            }
                            else {
                                System.out.println("não foi possível realizar a transferência");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Quanto deseja sacar? ");
                    double valorSaque = scanner.nextDouble();
                    if (opcaoCliente == 1) {
                        if (contatiago.sacar(valorSaque)) {
                            System.out.println("O novo saldo desta conta é: " + contatiago.getSaldo());
                        }
                        else {
                            System.out.println("Não foi possível realizar o saque.");
                        }
                    }
                    if (opcaoCliente == 2) {
                        if (contadiego.sacar(valorSaque)) {
                            System.out.println("O novo saldo desta conta é: " + contadiego.getSaldo());
                        }
                        else {
                            System.out.println("Não foi possível realizar o saque.");
                        }
                    }
                    break;
                case 4:
                    if (opcaoCliente == 1) {
                        System.out.println(contatiago.retornarSaldoComChequeEspecial());
                    }
                    if (opcaoCliente == 2) {
                        System.out.println(contadiego.retornarSaldoComChequeEspecial());
                    }
                    break;
                case 5:
                    if (opcaoCliente == 1) {
                        contatiago.imprimir();
                    }
                    if (opcaoCliente == 2) {
                        contadiego.imprimir();
                    }
                    break;
                case 6:
                    opcoesOk = false;
                default:
                    System.out.println("Operação finalizada Obrigado por usar nossos serviços.");
                    break;

            }

        }
    }
}

