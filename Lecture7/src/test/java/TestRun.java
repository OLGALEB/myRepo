import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRun {

    private static final String URL = "https://www.oz.by";
    private static final String MY_EMAIL = "lebedevaolga021@gmail.com";
    private static final String MY_PASSWORD = "wPdAp9";
    private static final String BOOK_NAME = "Нейромант (м)";
    private static final int BASKET_SIZE = 1;


    private DriverManager driverManager;
    private HeaderForm headerForm;

    @BeforeClass
    public void beforeClass() {
        driverManager = new DriverManager();
        headerForm = new HeaderForm(driverManager.getDriver());
    }

    @AfterMethod
    public void afterClass() {
        driverManager.driverClose();
    }

    @Test
    public void putItemInBasket() {
        driverManager.getDriver().get(URL);
        headerForm.loginToSite(MY_EMAIL, MY_PASSWORD);
        GridOfGoods gridOfGoods = headerForm.searchBook(BOOK_NAME);
        gridOfGoods.selectItem().putItemInBasket();
        headerForm.navigateToBasket().checkSelectedItemLocateInBasket(BOOK_NAME, BASKET_SIZE);
    }
}