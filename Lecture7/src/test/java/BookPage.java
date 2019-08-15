import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BookPage extends Page {

    @FindBy(className = "i-button__icon")
    private WebElement putBookInBasket;

    public BookPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void putItemInBasket() {
        putBookInBasket.click();
    }
}