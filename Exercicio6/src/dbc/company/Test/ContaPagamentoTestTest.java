package dbc.company.Test;

import dbc.company.ContaPagamento;
import org.junit.Test;

import static org.junit.Assert.*;

class ContaPagamentoTestTest {
    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoCOmSucesso(){
        //Arrange
        ContaPagamento.contapagamento tiagoPagamento = new ContaPagamento.contapagamento();
        tiagoPagamento.setSaldo(1500.00);

        //Act
        Boolean sacar = tiagoPagamento.sacar(300.00);
        Double saldo = tiagoPagamento.getSaldo();

        //Assert
        assertTrue(sacar);
        assertEquals(1195.75, saldo, 0);
    }
    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){
        //Arrange
        ContaPagamento tiagoPagamento;
        tiagoPagamento = new ContaPagamento();
        tiagoPagamento.setSaldo(1500.00);

        //Act
        ContaPagamento.contapagamento tiagopagamento = null;
        Boolean sacar = tiagoPagamento.sacar(3000.00);
        Double saldo =tiagoPagamento.getSaldo();

        //Assert
        assertFalse(sacar);
        assertEquals(1500, saldo, 0);
    }



}