import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import playtika.ArmorFactory;
import playtika.ArmorItem;
import playtika.ItemsType;

public class FactoryTest extends Assert {

    @AfterClass
    public void afterClass() {

        System.out.println("All tests that belong to the class factory were passed!");
    }

    @DataProvider(name = "dataProviderForArmor")
    public Object[][] dataProvider() {
        return new Object[][]{
                {ItemsType.BOOT, 25, 50, "red"},
                {ItemsType.HELMET, 31, 45, "black"},
                {ItemsType.CUIRASS, 37, 55, "red"},
                {ItemsType.SHIELD, 55, 75, "gold"},
                {ItemsType.SWORD, 75, 87, "gold"}};
    }

    @Test(dataProvider = "dataProviderForArmor")
    public void testFactory(ItemsType itemsType, int weight, double cost, String color) {
        ArmorItem armorItem = ArmorFactory.buildArmorItem(itemsType, weight, cost, color);

        Assert.assertEquals(weight, armorItem.getWeight());
        Assert.assertEquals(cost, armorItem.getCost());
        Assert.assertEquals(color, armorItem.getColor());
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testException() {
        ArmorItem armorItem = ArmorFactory.buildArmorItem(null, 31, 45, "red");
    }
}