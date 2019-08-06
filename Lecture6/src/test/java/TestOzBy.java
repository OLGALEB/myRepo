import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOzBy {
    private WebDriver driver;
    private static final String PROPERTY_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_NAME = "chromedriver.exe";
    private static final String URL = "https://www.oz.by";
    private static final String MY_EMAIL = "lebedevaolga021@gmail.com";
    private static final String MY_PASSWORD = "wPdAp9";
    private static final String BOOK_NAME = "Нейромант (м)";
    private static final long TIMEOUT = 1;
    private static final String LOGIN_BAR = "top-panel__userbar__auth";
    private static final String LOGIN_BY_EMAIL = "loginFormLoginEmailLink";
    private static final String EMAIL_FIELD = "cl_email";
    private static final String PASSWORD_FIELD = "//*[@name=\"cl_psw\"]";
    private static final String LOGIN_CLICK = "#loginForm > button";
    private static final String TOP_SEARCH_BAR = "top-s";
    private static final String CLICK_SEARCH = "top-panel__search__btn";
    private static final String CLICK_ON_ELEMENT = "item-type-card";
    private static final String CLICK_ON_BASKET = "i-button__icon";
    private static final String CHECK_BASKET = "//a[contains(.,'Корзина')]";
    private static final String BOOK_IN_BASKET = "//a[contains(.,'Нейромант (м)')]";


    @BeforeClass
    public void beforeClass() {
        System.setProperty(PROPERTY_DRIVER, DRIVER_NAME);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    private void loginSelectAndAddBookToBasket() {
        driver.get(URL);
        loginToSite();
        searchBook(BOOK_NAME);
        putInBasket();
        checkBasket(BOOK_NAME);
    }

    public void loginToSite() {
        driver.findElement(By.className(LOGIN_BAR)).click();
        driver.findElement(By.id(LOGIN_BY_EMAIL)).click();
        driver.findElement(By.name(EMAIL_FIELD)).sendKeys(MY_EMAIL);
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(MY_PASSWORD);
        driver.findElement(By.cssSelector(LOGIN_CLICK)).click();
    }

    public void searchBook(String bookName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TOP_SEARCH_BAR))).sendKeys(bookName);

        driver.findElement(By.className(CLICK_SEARCH)).click();
    }

    public void putInBasket() {
        driver.findElement(By.className(CLICK_ON_ELEMENT)).click();
        driver.findElement(By.className(CLICK_ON_BASKET)).click();

    }

    public List<String> getListOfBooks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECK_BASKET))).click();
        List<String> allBooksLinks = driver.findElements(By.xpath(BOOK_IN_BASKET)).stream().map(WebElement::getText).collect(Collectors.toList());
        return allBooksLinks;
    }

    public void checkBasket(String bookName) {
        assertThat(getListOfBooks()).hasSize(1).contains(bookName);
    }
}