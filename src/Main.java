import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var frutas = Arrays.asList("maça", "banana", "cereja").stream();
        // var primeiraFruta = frutas.filter(f -> f.startsWith("m")).findFirst();
        // System.out.println(primeiraFruta.get());

        // var frutasUpercase = frutas.map(f -> f.toUpperCase()).toList();
        // System.out.println(frutasUpercase.get(2));

        // var frutasUpercase = frutas.map(String::toUpperCase).toList();
        // System.out.println(frutasUpercase.get(2));

        // var frutasOrdenadas  = frutas.sorted().toList();
        // System.out.println(frutasOrdenadas.getFirst());

        // frutas.forEach(f -> System.out.println(f));
        frutas.forEach(System.out::println);

        /*da pra fazer iterações normais com for e while sem o stream, basicamente ele é para usar 
         metodos e só funciona uma vez */


    }

}
