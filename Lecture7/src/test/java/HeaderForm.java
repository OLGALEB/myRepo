import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderForm {

    private WebDriver driver;
    private static final long TIMEOUT = 1;
    private HomePage homePage;
    private GridOfGoods gridOfGoods;
    private BasketPage basketPage;

    @FindBy(className = "top-panel__userbar__auth")
    @CacheLookup
    private WebElement loginBar;
    @FindBy(id = "loginFormLoginEmailLink")
    @CacheLookup
    private WebElement loginByEmail;
    @FindBy(name = "cl_email")
    @CacheLookup
    private WebElement emailField;
    @FindBy(xpath = "//*[@name=\"cl_psw\"]")
    @CacheLookup
    private WebElement passwordField;
    @FindBy(css = "#loginForm > button")
    @CacheLookup
    private WebElement loginConfirm;
    @FindBy(id = "top-s")
    @CacheLookup
    private WebElement topSearchBar;
    @FindBy(className = "top-panel__search__btn")
    @CacheLookup
    private WebElement clickSearch;
    @FindBy(xpath = "//a[contains(.,'Корзина')]")
    @CacheLookup
    private WebElement basketButton;

    public HeaderForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToSite(String email, String password) {
        loginBar.click();
        loginByEmail.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginConfirm.click();
    }

    public void searchBook(String bookName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("top-s"))).sendKeys(bookName);
        clickSearch.click();
    }

    public void clickBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Корзина')]"))).click();
    }
}