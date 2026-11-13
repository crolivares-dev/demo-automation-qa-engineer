package steps;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    // Este hook se ejecutará en todos los escenarios EXCEPTO los que tengan el tag @api
    @Before("not @api")
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After("not @api")
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed() && driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Captura de pantalla del fallo: " + scenario.getName());
            } catch (Exception e) {
                System.out.println("Error al tomar la captura de pantalla: " + e.getMessage());
            }
        }

        DriverFactory.quitDriver();
    }
}