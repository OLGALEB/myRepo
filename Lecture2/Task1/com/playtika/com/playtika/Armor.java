package com.playtika;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Armor implements Serializable {

    public final List<ArmorItem> armorItems = new ArrayList<>();

    public Armor(List<ArmorItem> armorItems) {
        this.armorItems.addAll(armorItems);
    }

    public Armor() {

    }

    public int getWeight() {

        int armorWeight = 0;
        for (ArmorItem armorItem : armorItems) {
            armorWeight = armorWeight + armorItem.getWeight();
        }
        return armorWeight;
    }



    public double getCost() {
        double armorCost = 0;
        for (ArmorItem armorItem : armorItems) {
            armorCost = armorCost + armorItem.getCost();
        }
        return armorCost;
    }

    public List<ArmorItem> getByWeight(int minWeight, int maxWeight) {
        List<ArmorItem> resultWeight = new ArrayList<>();
        for (ArmorItem armorArmorItem : armorItems) {
            if (armorArmorItem.getWeight() >= minWeight && armorArmorItem.getWeight() <= maxWeight) {
                resultWeight.add(armorArmorItem);
            }
        }
        return resultWeight;
    }

    public List<ArmorItem> getByCost(int minCost, int maxCost) {
        List<ArmorItem> resultCost = new ArrayList<>();
        for (ArmorItem armorArmorItem : armorItems) {
            if (armorArmorItem.getCost() >= minCost && armorArmorItem.getCost() <= maxCost) {
                resultCost.add(armorArmorItem);
            }
        }
        return resultCost;
    }

    public List<ArmorItem> getByMinCost(int minCost) {
        List<ArmorItem> resultCost = new ArrayList<>();
        for (ArmorItem armorArmorItem : armorItems) {
            if (armorArmorItem.getCost() >= minCost) {
                resultCost.add(armorArmorItem);
            }
        }
        return resultCost;
    }

    public List<ArmorItem> getByMaxCost(int maxCost) {
        List<ArmorItem> resultCost = new ArrayList<>();
        for (ArmorItem armorArmorItem : armorItems) {
            if (armorArmorItem.getCost() <= maxCost) {
                resultCost.add(armorArmorItem);
            }
        }
        return resultCost;
    }

    public List<ArmorItem> sortedByCost() {
        List<ArmorItem> sortedValue = new ArrayList<>();
        sortedValue.addAll(armorItems);
        sortedValue.sort(Comparator.comparingDouble(i -> i.getCost())
        );
        return sortedValue;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "armorItems=" + armorItems +
                '}';
    }
}