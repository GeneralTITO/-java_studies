public class saldoInsuficienteException extends Exception {
    public saldoInsuficienteException() {
        super("saldo insuficiente");
    }

    public saldoInsuficienteException(String msg) {
        super(msg);
    }

}
