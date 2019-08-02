import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestOzBy {
    private WebDriver driver;
    private final String PROPERTY_DRIVER = "webdriver.chrome.driver";
    private final String DRIVER_EXE = "chromedriver.exe";
    private final String URL = "https://www.oz.by";
    private final String MY_EMAIL = "lebedevaolga021@gmail.com";
    private final String MY_PASSWORD = "wPdAp9";
    private final String BOOK_NAME = "Нейромант";
    private final long TIMEOUT = 1;
    private final String LOGIN_BAR = "top-panel__userbar__auth";
    private final String LOGIN_BY_EMAIL = "loginFormLoginEmailLink";
    private final String EMAIL_FIELD = "cl_email";
    private final String PASSWORD_FIELD = "//*[@name=\"cl_psw\"]";
    private final String LOGIN_CLICK = "#loginForm > button";
    private final String TOP_SEARCH_BAR = "top-s";
    private final String CLICK_SEARCH = "top-panel__search__btn";
    private final String CLICK_ON_ELEMENT = "item-type-card";
    private final String CLICK_ON_BASKET = "i-button__icon";
    private final String CHECK_BASKET = "//*[@id=\"top-page\" or @name='Корзина']";

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        System.setProperty(PROPERTY_DRIVER, DRIVER_EXE);
        driver = new ChromeDriver();
        implicitWait();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    private void loginSelectAndAddBookToBasket() throws InterruptedException {
        driver.get(URL);
        loginToSite();
        searchBook();
        putInBasket();
        checkBasket();
    }

    public void loginToSite() throws InterruptedException, NoSuchElementException {
        driver.findElement(By.className(LOGIN_BAR)).click();
        driver.findElement(By.id(LOGIN_BY_EMAIL)).click();
        driver.findElement(By.name(EMAIL_FIELD)).sendKeys(MY_EMAIL);
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(MY_PASSWORD);
        driver.findElement(By.cssSelector(LOGIN_CLICK)).click();
    }

    public void searchBook() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TOP_SEARCH_BAR))).sendKeys(BOOK_NAME);

        driver.findElement(By.className(CLICK_SEARCH)).click();
    }

    public void putInBasket() {
        driver.findElement(By.className(CLICK_ON_ELEMENT)).click();
        driver.findElement(By.className(CLICK_ON_BASKET)).click();

    }

    public void checkBasket() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECK_BASKET))).click();
    }

    private void implicitWait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }
}