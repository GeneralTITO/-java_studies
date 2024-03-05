public class Main {
    public static void main(String[] args) {
        var meuCarro = new Carro("toyota", 2000, "laranja");
        meuCarro.acelerar();
        meuCarro.freiar();

        System.out.println(meuCarro.cor+meuCarro.ano);
    }
}