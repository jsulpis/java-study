package cucumber;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefs implements En {

    private ShoppingCart shoppingCart;
    private Product product;
    private List<Product> products;

    public MyStepdefs() {
        Given("an empty shopping cart", () -> shoppingCart = new ShoppingCart());

        And("a product which costs {float}", (Number price) -> product = new Product("name", price.floatValue()));

        When("I add the product to the shopping cart", () -> shoppingCart.add(product));

        Then("the shopping cart contains the product", () -> assertThat(shoppingCart.getProducts()).contains(product));

        And("^the total number of products is (\\d+)$", (Integer number) -> assertThat(shoppingCart.getSize()).isEqualTo(number));

        Then("the total amount is the price of the product", () -> assertThat(shoppingCart.getTotal()).isEqualTo(product.getPrice()));

        And("the total amount is {float}", (Number total) -> assertThat(shoppingCart.getTotal()).isEqualTo(total));

        And("^a list of products:$", (DataTable dataTable) -> products = dataTable.transpose().asList(Product.class));


    }
}
