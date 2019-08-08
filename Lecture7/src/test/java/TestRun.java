import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRun {
    private static final String URL = "https://www.oz.by";
    private static final String MY_EMAIL = "lebedevaolga021@gmail.com";
    private static final String MY_PASSWORD = "wPdAp9";
    private static final String BOOK_NAME = "Нейромант (м)";

    private HomePage homePage;
    private BookPage bookPage;
    private DriverManager driverManager;
    private BasketPage basketPage;
    private GridOfGoods gridOfGoods;
    private HeaderForm headerForm;

    @BeforeClass
    public void beforeClass() {
        driverManager = new DriverManager();
        headerForm = new HeaderForm(driverManager.getDriver());
        homePage = new HomePage(driverManager.getDriver());
        gridOfGoods = new GridOfGoods(driverManager.getDriver());
        bookPage = new BookPage(driverManager.getDriver());
        basketPage = new BasketPage(driverManager.getDriver());
    }
    @AfterMethod
    public void afterClass() {
        driverManager.getDriver().quit();
    }

    @Test
    public void test() {
        driverManager.getDriver().get(URL);
        headerForm.loginToSite(MY_EMAIL, MY_PASSWORD);
        headerForm.searchBook(BOOK_NAME);
        gridOfGoods.clickOnElementFromGrid();
        bookPage.putBookInBasket();
        headerForm.clickBasket();
        basketPage.checkBasket(BOOK_NAME);
    }
}