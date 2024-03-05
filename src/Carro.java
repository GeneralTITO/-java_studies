public class Carro {
    // atributos da classe
    String marca;
    int ano;
    String cor;

    // metodos da classe
    void acelerar() {
        System.out.println("Carro acelera");
    }

    void freiar() {
        System.out.println("Carro freia");
    }

    void buzinar() {
        System.out.println("beep!");
    }

    // construtor = usando com esse this, ta dizendo q para criar vai precisar dessas informações
    Carro(String marca, int ano, String cor) {
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
    }
}
