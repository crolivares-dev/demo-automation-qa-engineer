package steps;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import page.SauceDemoLoginPage;
import page.SauceDemoInventoryPage;
import page.SauceDemoProductPage;

public class SauceDemoSteps {

    private SauceDemoLoginPage loginPage;
    private SauceDemoInventoryPage inventoryPage;
    private SauceDemoProductPage productPage;

    // --- STEPS DE LOGIN ---

    @Given("el usuario navega a la URL de Sauce Demo")
    public void elUsuarioNavegaALaURLDeSauceDemo() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        loginPage = new SauceDemoLoginPage(DriverFactory.getDriver());
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void ingresaElUsuarioYLaContrasena(String user, String password) {
        loginPage.login(user, password);
        inventoryPage = new SauceDemoInventoryPage(DriverFactory.getDriver());
    }

    @Then("se muestra el mensaje de error {string}")
    public void seMuestraElMensajeDeError(String mensajeEsperado) {
        String mensajeActual = loginPage.getErrorMessageText();
        Assertions.assertEquals(mensajeEsperado, mensajeActual, "El mensaje de error no coincide con el esperado.");
    }

    // --- STEPS DE CARRITO ---

    @Then("se muestra el catálogo de productos de Sauce Demo")
    public void seMuestraElCatalogoDeProductosDeSauceDemo() {
        Assertions.assertTrue(inventoryPage.isTitleDisplayed(), "El catálogo de productos no es visible.");
    }

    @When("agrega el primer producto al carrito")
    public void agregaElPrimerProductoAlCarrito() {
        inventoryPage.addFirstProductToCart();
    }

    @Then("el producto se añade correctamente al carrito")
    public void elProductoSeAnadeCorrectamenteAlCarrito() {
        Assertions.assertTrue(inventoryPage.isProductAddedToCart(), "El producto no se añadió correctamente al carrito.");
    }

    @When("agrega el segundo producto al carrito")
    public void agregaElSegundoProductoAlCarrito() {
        inventoryPage.addSecondProductToCart();
    }

    @Then("el contador del carrito muestra {string}")
    public void elContadorDelCarritoMuestra(String cantidadEsperada) {
        Assertions.assertEquals(cantidadEsperada, inventoryPage.getCartBadgeText(), "La cantidad en el carrito es incorrecta.");
    }

    @When("remueve el primer producto desde el catálogo")
    public void remueveElPrimerProductoDesdeElCatalogo() {
        inventoryPage.removeFirstProductFromCart();
    }

    @Then("el contador del carrito desaparece")
    public void elContadorDelCarritoDesaparece() {
        Assertions.assertTrue(inventoryPage.isCartBadgeInvisible(), "El badge del carrito sigue visible y debería haber desaparecido.");
    }

    @When("hace clic en el título del primer producto")
    public void haceClicEnElTituloDelPrimerProducto() {
        inventoryPage.clickFirstProductTitle();
        productPage = new SauceDemoProductPage(DriverFactory.getDriver());
    }

    @When("agrega el producto al carrito desde su vista de detalle")
    public void agregaElProductoAlCarritoDesdeSuVistaDeDetalle() {
        productPage.addToCart();
    }
}