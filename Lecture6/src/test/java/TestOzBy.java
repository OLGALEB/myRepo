import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestOzBy {
    private WebDriver driver;
    private final String URL = "https://www.oz.by";
    private final String MY_EMAIL = "lebedevaolga021@gmail.com";
    private final String MY_PASSWORD = "wPdAp9";

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    private void loginSelectAndAddBookToBasket() throws InterruptedException {
        driver.get(URL);
        implicitWait();
        loginToSite();
        implicitWait();
        searchBook();
        implicitWait();
        putInBasket();
        checkBasket();
        implicitWait();
    }

    public void loginToSite() throws InterruptedException, NoSuchElementException {
        WebElement loginBar = driver.findElement(By.className("top-panel__userbar__auth"));
        loginBar.click();
        WebElement enterByEmail = driver.findElement(By.id("loginFormLoginEmailLink"));
        enterByEmail.click();
        WebElement emailField = driver.findElement(By.name("cl_email"));
        emailField.sendKeys(MY_EMAIL);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/div[1]/div[2]/input"));
        passwordField.sendKeys(MY_PASSWORD);
        WebElement clickLogin = driver.findElement(By.cssSelector("#loginForm > button"));
        clickLogin.click();
    }

    public void searchBook() throws StaleElementReferenceException {

        try {
            WebElement searchBar = driver.findElement(By.id("top-s"));
            searchBar.sendKeys("Hейромант");
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement startSearch = driver.findElement(By.className("top-panel__search__btn"));
        startSearch.click();
    }

    public void putInBasket() throws NoSuchElementException {
        WebElement book = driver.findElement(By.className("item-type-card"));
        book.click();
        WebElement putInBasket = driver.findElement(By.className("i-button__icon"));
        putInBasket.click();

    }

    public void checkBasket() throws NoSuchElementException {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-page\"]/div[1]/div[2]/div/ul/li[5]"))).click();
    }

    private void implicitWait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}