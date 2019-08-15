import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }
}