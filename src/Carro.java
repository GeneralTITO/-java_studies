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

    // construtor = quando uma classe pode ser iniciada
    Carro(String marca, int ano, String cor) {
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
    }
}
