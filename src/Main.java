import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tipos Primitivos
        byte assd = 1; /* -128 até 127 */
        short assaaasdd = 1; /* -32,768 a 32,767 */
        int assasdaad = 1; /* -2^31 a 2^31-1 */
        long assasdad = 1L; /* -2^63 a 2^63-1 */

        float gtbrg = 1.0F;
        double afth = 1.0; /* por padrão quando é flutuante vira doble, por isso n precisa de sufixo */

        char a = 'A';
        boolean x = true;
        var y = false;

        // tipos de referencia
        // classes

        // interfaces
        List<String> list = new ArrayList<>();

        int[] intArray = new int[10];

        String[] srtArray = new String[5];
        System.out.println(intArray.length);

    }
}