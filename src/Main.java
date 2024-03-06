import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import product.ProductController;
import product.ProductModel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();

        // Exemplo de uso
        ProductModel product1 = new ProductModel("123456", "Produto A", 500, 10);
        ProductModel product2 = new ProductModel("789012", "Produto B", 800, 15);

        try {
            System.out.println(productController.create(product1));
            System.out.println(productController.create(product2));

            List<ProductModel> productList = productController.read();
            System.out.println("Produtos: " + productList);

            String barCode = "123456";
            System.out.println("Preço do produto com código de barras '" + barCode + "': " + productController.retrievePrice(barCode));

            // Tentativa de criar produto com preço negativo
            ProductModel invalidProduct = new ProductModel("654321", "Produto C", -100, 5);
            productController.create(invalidProduct);
        } catch (NegativePriceException | NotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
