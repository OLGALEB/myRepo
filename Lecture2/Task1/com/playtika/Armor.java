package com.playtika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Armor {

    public final List<ArmorItem> totalArmorItems = new ArrayList<>();

    public Armor(List<ArmorItem> armorItems){

        this.totalArmorItems.addAll(armorItems);
    }

    public int getWeight() {
        int armorWeight = 0;
        for (ArmorItem armorItem : totalArmorItems) {
            armorWeight = armorWeight + armorItem.weight;
        }
        return armorWeight;
    }
    public double getCost() {
        double armorCost = 0;
        for (ArmorItem armorItem : totalArmorItems) {
            armorCost = armorCost + armorItem.cost;
        }
        return armorCost;
    }

    public List<ArmorItem> getByWeight(int minWeight, int maxWeight){
        List<ArmorItem> resultWeight = new ArrayList<>();
        for (ArmorItem armorArmorItem : totalArmorItems) {
            if ( armorArmorItem.weight >= minWeight && armorArmorItem.weight <= maxWeight) {
                resultWeight.add(armorArmorItem);
            }
        }
        return resultWeight;
    }

    public List<ArmorItem> getByCost(int minCost, int maxCost){
        List<ArmorItem> resultCost = new ArrayList<>();
        for (ArmorItem armorArmorItem : totalArmorItems) {
            if ( armorArmorItem.cost >= minCost && armorArmorItem.cost <= maxCost) {
                resultCost.add(armorArmorItem);
            }
        }
        return resultCost;
    }

    public List<ArmorItem> sortedByCost(){
        List<ArmorItem> sortedValue = new ArrayList<>();
        sortedValue.addAll(totalArmorItems);
        Collections.sort(sortedValue, new Comparator<ArmorItem>() {
            @Override
            public int compare(ArmorItem i1, ArmorItem i2) {
                if (i1.cost < i2.cost) return -1;
                else if (i1.cost == i2.cost) return 0;
                else return 1;
            }

        });
        return sortedValue;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "totalArmorItems=" + totalArmorItems +
                '}';
    }
}

