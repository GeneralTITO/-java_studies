import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var frutas = Arrays.asList("maça", "banana", "cereja").stream();
        var primeiraFruta = frutas.filter(f -> f.startsWith("m")).findFirst();
        System.out.println(primeiraFruta.get());
    }

}
