package dbc.company;

import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;


public class MeuTexte
    @Test

    public  void deveTestarSeonumeroEparcomSucesso(){

        // Setup
        int valor = 10;

        // ACT AÇÃO
        boolean ehpar = valor % 2 == 0;

        //ASSERT (VERIFICAÇÃO)
        assertTrue(ehpar);
    }
    @Test
    public void devetestarseonumeroeparsemsucesso(){

        // Setup
        int valor = 11;

        // ACT AÇÃO
        boolean ehpar = valor % 2 == 0;

        //ASSERT (VERIFICAÇÃO)
        assertFalse(ehpar);
    }
    @Test
    public voide devetestarvalorigual(){
        // Setup
        Integer idade =31;
        String porExtenso = "tiago tem " + idade + "anos.";


        //ASSERT (VERIFICAÇÃO)
        assert ;

    }

}
