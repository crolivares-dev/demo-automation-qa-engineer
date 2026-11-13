package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (driver.get() == null) {
            String browser = System.getProperty("browser", "chrome").toLowerCase();
            WebDriver localDriver;

            switch (browser) {
                case "firefox":
                    localDriver = new FirefoxDriver();
                    break;
                case "edge":
                    localDriver = new EdgeDriver();
                    break;
                case "chrome":
                default:
                    localDriver = new ChromeDriver();
                    break;
            }

            localDriver.manage().window().maximize();
            driver.set(localDriver);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}