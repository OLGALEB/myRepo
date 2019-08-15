import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final String PROPERTY_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_NAME = "chromedriver.exe";
    private static final long TIMEOUT = 1;
    private WebDriver driver;

    public DriverManager() {
        System.setProperty(PROPERTY_DRIVER, DRIVER_NAME);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    public void driverClose (){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}