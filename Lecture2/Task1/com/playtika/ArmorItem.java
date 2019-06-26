package com.playtika;

public class ArmorItem {

    public final double cost;
    public final int weight;

    public ArmorItem(double cost, int weight) {
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ArmorItem{" +
                "cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
