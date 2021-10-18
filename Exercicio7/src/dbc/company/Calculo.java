package dbc.company;
@interface calculo;

public interface Calculo {
    default String gerar(String valor) {
        final String o = null;
        return o;
    }

    int gerar(int valor);

}
