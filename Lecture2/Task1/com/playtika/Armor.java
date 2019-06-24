package com.playtika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Armor {

    public final List<Item> totalItems = new ArrayList<>();

    public Armor(Helmet helmet, Cuirass cuirass, Boot leftBoot, Boot rightBoot, Sword sword, Shield shield) {
        this.totalItems.add(helmet);
        this.totalItems.add(cuirass);
        this.totalItems.add(leftBoot);
        this.totalItems.add(rightBoot);
        this.totalItems.add(sword);
        this.totalItems.add(shield);
    }

    public int getWeight() {
        int armorWeight = 0;
        for (Item item : totalItems) {
            armorWeight = armorWeight + item.weight;
        }
        return armorWeight;
    }
    public int getCost() {
        int armorCost = 0;
        for (Item item : totalItems) {
            armorCost = armorCost + item.cost;
        }
        return armorCost;
    }

    public List<Item> getByWeight(int minWeight, int maxWeight){
        List<Item> resultWeight = new ArrayList<>();
        for (Item armorItem : totalItems) {
            if ( armorItem.weight >= minWeight && armorItem.weight <= maxWeight) {
                resultWeight.add(armorItem);
            }
        }
        return resultWeight;
    }

    public List<Item> getByCost(int minCost, int maxCost){
        List<Item> resultCost = new ArrayList<>();
        for (Item armorItem : totalItems) {
            if ( armorItem.cost >= minCost && armorItem.cost <= maxCost) {
                resultCost.add(armorItem);
            }
        }
        return resultCost;
    }

    public List<Item>  sorterByCost(){
        List<Item> sortedValue = new ArrayList<>();
        sortedValue.addAll(totalItems);
        Collections.sort(sortedValue, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
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
                "totalItems=" + totalItems +
                '}';
    }
}

