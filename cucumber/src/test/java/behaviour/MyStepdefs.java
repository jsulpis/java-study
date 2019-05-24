package behaviour;

import cucumber.Product;
import cucumber.ShoppingCart;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs implements En {

    private ShoppingCart shoppingCart;
    private Product product;
    private List<Product> products;

    public MyStepdefs() {
        commonAssertions();
        addingAProduct();
        addingManyProducts();
    }

    private void commonAssertions() {
        Given("an empty shopping cart", () -> shoppingCart = new ShoppingCart());

        And("the total number of products is {int}", (Integer number) -> assertThat(shoppingCart.getSize()).isEqualTo(number));

        And("the total amount is {float}", (Number total) -> assertThat(shoppingCart.getTotal()).isEqualTo(total));
    }

    private void addingAProduct() {
        And("a product which costs {float}", (Number price) -> product = new Product("name", price.floatValue()));

        When("I add the product to the shopping cart", () -> shoppingCart.add(product));

        Then("the shopping cart contains the product", () -> {
            assertThat(shoppingCart.getProducts().size()).isEqualTo(1);
            assertThat(shoppingCart.getProducts()).contains(product);
        });
    }

    private void addingManyProducts() {
        And("a list of products:", (DataTable dataTable) ->
                products = dataTable.transpose().asLists()
                        .stream()
                        .skip(1)
                        .map(strings -> new Product(strings.get(0), Float.parseFloat(strings.get(1))))
                        .collect(Collectors.toList()));

        When("^I add all the products to the shopping cart$", () -> shoppingCart.addAll(products));

        Then("^the shopping cart contains all the products$", () -> {
            Set<Product> actualProductSet = shoppingCart.getProducts();
            assertThat(actualProductSet.size()).isEqualTo(products.size());
            for (Product p : products)
                assertThat(actualProductSet).contains(p);
        });
    }
}
