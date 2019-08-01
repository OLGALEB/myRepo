import com.playtika.*;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.playtika.Main.buildArmor;

public class TestForOtherMethods {

    @BeforeClass
    public void beforeClass() {

        System.out.println("Test starts:");
    }

    @Test
    public void testToGetTotalWeightSum() {
        int totalWeightSum = 355;
        Assert.assertEquals(totalWeightSum, buildArmor().getWeight());

    }


    @Test
    public void testToGetTotalCostSum() {
        double totalCostSum = 485.0;
        Assert.assertEquals(totalCostSum, buildArmor().getCost());
    }

    @Test
    public void testForAmmunitionWhichFallenInUserSample() {
        List<ArmorItem> listWithSortedItem = new ArrayList<>();
        listWithSortedItem.add(ArmorFactory.buildArmorItem(ItemsType.CUIRASS, 55, 100, "gold"));
        listWithSortedItem.add(ArmorFactory.buildArmorItem(ItemsType.SHIELD, 115, 125, "red"));
        listWithSortedItem.add(ArmorFactory.buildArmorItem(ItemsType.SWORD, 125, 155, "silver"));

        Assertions.assertThat(listWithSortedItem).isEqualTo(buildArmor().getByCost(100, 155));
    }

    @Test
    public void testToGetSortedByCostArmor() {
        List<ArmorItem> sortedByCostList = new ArrayList<>();
        sortedByCostList.add(ArmorFactory.buildArmorItem(ItemsType.BOOT, 25, 50, "black"));
        sortedByCostList.add(ArmorFactory.buildArmorItem(ItemsType.HELMET, 35, 55, "gold"));
        sortedByCostList.add(ArmorFactory.buildArmorItem(ItemsType.CUIRASS, 55, 100, "gold"));
        sortedByCostList.add(ArmorFactory.buildArmorItem(ItemsType.SHIELD, 115, 125, "red"));
        sortedByCostList.add(ArmorFactory.buildArmorItem(ItemsType.SWORD, 125, 155, "silver"));

        Assertions.assertThat(sortedByCostList).isEqualTo(buildArmor().sortedByCost());
    }


    @Test
    public void testWriteAndReadFile() throws IOException, ClassNotFoundException {
        Knight knight = new Knight(23, "Art", buildArmor(), "soldier");
        String fileName = "Knight.txt";
        Main.writeToFile(knight, fileName);

        Knight actual = Main.readKnightInfoFromTxtFile(fileName);
        Assertions.assertThat(actual).isEqualToComparingFieldByFieldRecursively(knight);
    }
}