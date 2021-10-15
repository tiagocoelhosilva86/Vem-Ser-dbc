package dbc.company.Test;


import dbc.company.ContaCorrente;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaCorrenteTestTest {
    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoCOmSucesso(){
        //Arrange
        ContaCorrente contatiago = new ContaCorrente();
        contatiago.setSaldo(1500.00);
        contatiago.setChequeEspecial(1000.00);

        //Act
        Boolean sacar = contatiago.sacar(300.00);
        Double saldo = contatiago.getSaldo();

        //Assert
        assertTrue(sacar);
        assertEquals(1200, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo(){
        //Arrange
        ContaCorrente contatiago = new ContaCorrente();
        contatiago.setSaldo(1500.00);
        contatiago.setChequeEspecial(1000.00);

        //Act
        Boolean sacar = contatiago.sacar(3000.00);
        Double saldo = contatiago.getSaldo();

        //Assert
        assertFalse(sacar);
        assertEquals(1500, saldo, 0);
    }



}