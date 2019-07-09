
package com.playtika.task1.lecture3;

import java.util.Arrays;
import java.util.List;

public class ArmorFactory { // Task4
    public static Armor buildArmor(String helmColor,String bootColor,String color) {
        List<ArmorItem> armorList = Arrays.asList(
                new Helmet(helmColor, HelmType.CLOSED, 5, 10, 15),
                new Cuirass(color, 15, 25, 35),
                new Boot(bootColor, 20, 30, 21),
                new Boot(bootColor, 15, 10, 15),
                new Shield(color, 27, 31, 19),
                new Sword(color,24,50,29,15)
        );
        return new Armor(armorList);
    }
}