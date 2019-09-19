import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Armor2 firstSuite = buildArmor();
    }

    public static Armor2 buildArmor() {
        List<ArmorItem> armorList = Arrays.asList(
                ArmorFactory.buildArmorItem(ItemsType.BOOT, 25, 50, "black"),
                ArmorFactory.buildArmorItem(ItemsType.CUIRASS, 55, 100, "gold"),
                ArmorFactory.buildArmorItem(ItemsType.HELMET, 35, 55, "gold"),
                ArmorFactory.buildArmorItem(ItemsType.SHIELD, 115, 125, "red"),
                ArmorFactory.buildArmorItem(ItemsType.SWORD, 125, 155, "silver")
        );
        return new Armor2(armorList);
    }
}
