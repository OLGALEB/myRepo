package com.playtika;

public class ArmorItem {

    private final double cost;
    private final int weight;

    ArmorItem(double cost, int weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "ArmorItem{" +
                "cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}