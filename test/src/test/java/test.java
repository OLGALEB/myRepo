import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void testToGetSortedByCostArmor() {
        Runner f = new Runner ();
Runner.buildArmor();

        List<ArmorItem> ourFirstArmorList = Runner.buildArmor().sortedByCost();

        List<ArmorItem> newSortedList = new ArrayList<>();
        ArmorFactory.buildArmorItem(ItemsType.BOOT, 25, 50, "black");
        ArmorFactory.buildArmorItem(ItemsType.CUIRASS,55, 100, "gold");
        ArmorFactory.buildArmorItem(ItemsType.HELMET,35,55,"gold");
        ArmorFactory.buildArmorItem(ItemsType.SHIELD,115,125,"red");
        ArmorFactory.buildArmorItem(ItemsType.SWORD,125,155,"silver");
        Assertions.assertThat(ourFirstArmorList).isEqualTo(newSortedList);


        //Assert.assertEquals(buildArmor().sortedByCost(), newSortedList);
    }




}

