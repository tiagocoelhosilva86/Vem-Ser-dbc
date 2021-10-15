package dbc.company.Test;

import dbc.company.ContaCorrente;
import org.junit.Test;

import static org.junit.Assert.*;

class TransferenciaTestTest {


    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        //Arrange
        ContaCorrente tiagoCorrente = new ContaCorrente();
        ContaCorrente diegoCorrente = new ContaCorrente();
        diegoCorrente.setSaldo(1500.00);
        tiagoCorrente.setSaldo(1000.00);
        diegoCorrente.setChequeEspecial(0.0);
        tiagoCorrente.setChequeEspecial(100.00);

        //Act
        Boolean transferir = diegoCorrente.transferir(tiagoCorrente, 300.00);
        Double transferencia = tiagoCorrente.getSaldo();

        //Assert
        assertTrue(transferir);
        assertEquals(1300, transferencia, 0);
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoSemSucesso(){
        //Arrange
        ContaCorrente diegoCorrente = new ContaCorrente();
        ContaCorrente tiagoCorrente = new ContaCorrente();
        tiagoCorrente.setSaldo(1500.00);
        diegoCorrente.setSaldo(1000.00);
        tiagoCorrente.setChequeEspecial(0.0);
        diegoCorrente.setChequeEspecial(100.00);

        //Act
        Boolean transferir = tiagoCorrente.transferir(diegoCorrente, 5000.00);
        Double transferencia = diegoCorrente.getSaldo();

        //Assert
        assertFalse(transferir);
        assertEquals(1000.00, transferencia, 0);
    }

}