import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HeaderForm  extends  Page {

    private static final long TIMEOUT = 1;

    @FindBy(className = "top-panel__userbar__auth")
    private WebElement loginBar;

    @FindBy(id = "loginFormLoginEmailLink")
    private WebElement loginByEmail;

    @FindBy(name = "cl_email")
    private WebElement emailField;

    @FindBy(xpath = "//*[@name=\"cl_psw\"]")
    private WebElement passwordField;

    @FindBy(css = "#loginForm > button")
    private WebElement loginConfirm;

    @FindBy(id = "top-s")
    private WebElement topSearchBar;

    @FindBy(className = "top-panel__search__btn")
    private WebElement clickSearch;

    @FindBy(xpath = "//a[contains(.,'Корзина')]")
    private WebElement basketButton;

    public HeaderForm(WebDriver webDriver) {
        super(webDriver);
    }

    public void loginToSite(String email, String password) {
        loginBar.click();
        loginByEmail.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginConfirm.click();
    }

    public GridOfGoods searchBook(String bookName) {
        waitForElementVisible(topSearchBar).sendKeys(bookName);
        clickSearch.click();
        return new GridOfGoods(driver);
    }

    public BasketPage navigateToBasket() {
        waitForElementVisible(basketButton).click();
        return new BasketPage(driver);
    }

    public WebElement waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}