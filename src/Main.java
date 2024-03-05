
public class Main {
    public static void main(String[] args) {

        var exemplo = new Exemplo();
        try {
            exemplo.verificarSaldo(-1);
            // exemplo.verificarIdade(5);
        } catch (saldoInsuficienteException e) {
            System.out.println("eita, só pode mais 18");

        } catch (Exception e) {
            System.out.println("aha");
        }

    }

}
