package cucumber;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {
    private Set<Product> products;

    public ShoppingCart() {
        products = new HashSet<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public Set<Product> getProducts() {
        return products;
    }

    public int getSize() {
        return products.size();
    }

    public float getTotal() {
        return products.stream().map(Product::getPrice).reduce(0F, (a, b) -> a + b);
    }
}
