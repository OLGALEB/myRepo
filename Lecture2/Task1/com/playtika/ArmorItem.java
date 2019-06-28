package com.playtika;

public class ArmorItem {

    private final double cost;
    private final int weight;

    public double getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    ArmorItem(double cost, int weight) {
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
