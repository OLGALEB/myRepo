import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridOfGoods extends Page {
    @FindBy(className = "item-type-card")
    private WebElement putItemFromGrid;

    public GridOfGoods(WebDriver webDriver) {
        super(webDriver);
    }

    public BookPage selectItem() {
        putItemFromGrid.click();
        return new BookPage(driver);
    }
}