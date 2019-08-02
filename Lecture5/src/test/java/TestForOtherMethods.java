import com.playtika.*;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
        Assertions.assertThat(listWithSortedItem).isEqualTo(buildArmor().getByCost(125, 10000000));
        Assertions.assertThat(listWithSortedItem).isNotEqualTo(buildArmor().getByCost(154, 155));
    }

    @Test
    public void testToGetSortedByCostArmor() {
        Assertions.assertThat(buildArmor().sortedByCost()).isSortedAccordingTo((Comparator.comparingDouble(ArmorItem::getCost)));
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