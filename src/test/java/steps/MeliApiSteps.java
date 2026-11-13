package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MeliApiSteps {

    private Response response;

    @Given("configuro la base URL de la API a {string}")
    public void configuroLaBaseURLDeLaAPIA(String baseUrl) {
        // Configuramos la URL base global para Rest Assured
        RestAssured.baseURI = baseUrl;
    }

    @When("realizo una petición GET al endpoint {string}")
    public void realizoUnaPeticionGETAlEndpoint(String endpoint) {
        // Ejecutamos el GET inyectando un User-Agent de Chrome para evitar el bloqueo antibot (403)
        response = RestAssured.given()
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .when()
                .get(endpoint);
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDebeSer(int statusCode) {
        // Validamos que el servidor responda OK
        Assertions.assertEquals(statusCode, response.getStatusCode(),
                "El código de estado HTTP no es el esperado.");
    }

    @Then("la respuesta del servicio debe contener el listado de departamentos")
    public void laRespuestaDelServicioDebeContenerElListadoDeDepartamentos() {
        // Convertimos el JSON de respuesta a un String para validarlo fácilmente
        String responseBody = response.getBody().asString();

        // El endpoint devuelve una estructura que incluye la palabra clave "departments".
        // Verificamos que no esté vacía y contenga el nodo esperado.
        Assertions.assertTrue(responseBody.contains("departments"),
                "El JSON de respuesta no contiene el nodo 'departments'. Respuesta obtenida: " + responseBody);
    }
}