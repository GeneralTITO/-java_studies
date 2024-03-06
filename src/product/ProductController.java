package product;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<ProductModel> products;

    public ProductController() {
        this.products = new ArrayList<>();
    }

    public String create(ProductModel payload) {
        if (payload.getPriceInCents() < 0) {
            throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
        }

        products.add(payload);
        return "Produto '" + payload.getName() + "' adicionado.";
    }

    public List<ProductModel> read() {
        return new ArrayList<>(products);
    }

    public int retrievePrice(String barCode) {
        for (ProductModel product : products) {
            if (product.getBarCode().equals(barCode)) {
                return product.getPriceInCents();
            }
        }
        throw new NotFoundException("Product not found.");
    }
}