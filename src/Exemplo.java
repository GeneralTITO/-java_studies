public class Exemplo {
    public void verificarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("só pode +18");
        }

    }

    public void verificarSaldo(int saldo) throws Exception {
        if (saldo < 0) {
            throw new saldoInsuficienteException("saldo indisponivel");
        }
    }
}
