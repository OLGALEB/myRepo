import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketPage extends Page {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfBooks(String bookName) {
        By bookElementLocator = By.xpath("//a[contains(.,'" + bookName + "')]");
        return driver.findElements(bookElementLocator)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public void checkSelectedItemLocateInBasket(String bookName, int basketSize) {
        assertThat(getListOfBooks(bookName)).hasSize(basketSize).contains(bookName);
    }
}