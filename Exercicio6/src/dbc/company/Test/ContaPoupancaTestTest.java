package dbc.company.Test;

import dbc.company.ContaPoupanca;
import org.junit.Test;

import static org.junit.Assert.*;

class ContaPoupancaTestTest {
    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){
        //Arrange
        ContaPoupanca tiagoPoupanca = new ContaPoupanca();
        tiagoPoupanca.setSaldo(1500.00);
        tiagoPoupanca.creditarTaxa();

        //Act
        Boolean sacar = tiagoPoupanca.sacar(300.00);
        Double saldo = tiagoPoupanca.getSaldo();

        //Assert
        assertTrue(sacar);
        assertEquals(1215, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo(){
        //Arrange
        ContaPoupanca tiagoPoupanca = new ContaPoupanca();
        tiagoPoupanca.setSaldo(1500.00);

        //Act
        Boolean sacar = tiagoPoupanca.sacar(3000.00);
        Double saldo = tiagoPoupanca.getSaldo();

        //Assert
        assertFalse(sacar);
        assertEquals(1500, saldo, 0);
    }

}