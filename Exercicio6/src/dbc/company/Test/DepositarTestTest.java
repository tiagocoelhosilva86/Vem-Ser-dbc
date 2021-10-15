package dbc.company.Test;

import dbc.company.ContaPagamento;
import org.junit.Test;

import static org.junit.Assert.*;

class DepositarTestTest {
    @Test
    public void deveTestarDepositoEVerificarSaldoCOmSucesso(){
        //Arrange
        ContaPagamento tiagoPagamento = new ContaPagamento();
        tiagoPagamento.setSaldo(1500.00);

        //Act
        Boolean deposito = tiagoPagamento.depositar(300.00);
        Double depositar = tiagoPagamento.getSaldo();

        //Assert
        assertTrue(deposito);
        assertEquals(1800.00, depositar, 0);
    }

    @Test
    public void deveTestarDepositoNegativo(){
        //Arrange
        ContaPagamento tiagoPagamento = new ContaPagamento();
        tiagoPagamento.setSaldo(1500.00);

        //Act
        Boolean deposito = tiagoPagamento.sacar(-650.00);
        Double depositar = tiagoPagamento.getSaldo();

        //Assert
        assertFalse(deposito);
        assertEquals(1500, depositar, 0);
    }

}