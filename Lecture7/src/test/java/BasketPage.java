import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketPage extends Page {

    private static final long TIMEOUT = 1;

    @FindBy(xpath = "//a[contains(.,'Корзина')]")
    @CacheLookup
    private WebElement checkBasket;
    @FindBy(xpath = "//a[contains(.,'Нейромант (м)')]")
    @CacheLookup
    private WebElement checkBookInbasket;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfBooks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Корзина')]"))).click();
        List<String> allBooksLinks = driver.findElements(By.xpath("//a[contains(.,'Нейромант (м)')]")).stream().map(WebElement::getText).collect(Collectors.toList());
        return allBooksLinks;
    }

    public void checkBasket(String bookName) {
        assertThat(getListOfBooks()).hasSize(1).contains(bookName);
    }
}