package dbc.company;
import java.util.Scanner;

public class EnumTest {

    public enum comida{

        japonesa("japonesa", 50.00),
        fast food("fast food", 30.00),
        tradicional("tradicional", 20.00);

        private double preco;
        private String nome;

        comida(String nome, double preco){
            this.nome = nome;
            this.preco = preco;
        }

        public double getPreco(){
            return this.preco;
        }

        public String getNome(){
            return this.nome;
        }
    }
    public enum Comida{
        japonesa("japonesa", 50.0),
        fast food("fast food", 30.0),
        tradicional("tradicional", 20.00);

        private double preco;
        private String nome;

        Comida(String nome, double preco){
            this.nome = nome;
            this.preco = preco;
        }

        public double getPreco(){
            return this.preco;
        }

        public String getNome(){
            return this.nome;
        }
    }