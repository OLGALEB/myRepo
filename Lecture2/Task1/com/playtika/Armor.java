package com.playtika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Armor {

    public final List<ArmorItem> armorItems = new ArrayList<>();

    public Armor(List<ArmorItem> armorItems){

        this.armorItems.addAll(armorItems);
    }

    int getWeight() {
        int armorWeight = 0;
        for (ArmorItem armorItem : armorItems) {
            armorWeight = armorWeight + armorItem.getWeight();
        }
        return armorWeight;
    }
    double getCost() {
        double armorCost = 0;
        for (ArmorItem armorItem : armorItems) {
            armorCost = armorCost + armorItem.getCost();
        }
        return armorCost;
    }

    public List<ArmorItem> getByWeight(int minWeight, int maxWeight){
        List<ArmorItem> resultWeight = new ArrayList<>();
        for (ArmorItem armorArmorItem : armorItems) {
            if ( armorArmorItem.getWeight() >= minWeight && armorArmorItem.getWeight() <= maxWeight) {
                resultWeight.add(armorArmorItem);
            }
        }
        return resultWeight;
    }

    public List<ArmorItem> getByCost(int minCost, int maxCost){
        List<ArmorItem> resultCost = new ArrayList<>();
        for (ArmorItem armorArmorItem : armorItems) {
            if ( armorArmorItem.getCost() >= minCost && armorArmorItem.getCost() <= maxCost) {
                resultCost.add(armorArmorItem);
            }
        }
        return resultCost;
    }

    public List<ArmorItem> sortedByCost(){
        List<ArmorItem> sortedValue = new ArrayList<>();
        sortedValue.addAll(armorItems);
        Collections.sort(sortedValue, (i1, i2) -> {
            if (i1.getCost() < i2.getCost()) return -1;
            else if (i1.getCost() == i2.getCost()) return 0;
            else return 1;
        });
        return sortedValue;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "armorItems=" + armorItems +
                '}';
    }
}

