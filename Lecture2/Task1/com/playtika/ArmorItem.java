package com.playtika;

import java.io.Serializable;

public class ArmorItem implements Serializable {

    private final double cost;
    private final int weight;
    private final String color;

    ArmorItem(double cost, int weight, String color) {
        this.cost = cost;
        this.weight = weight;
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "ArmorItem{" +
                "cost=" + cost +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArmorItem)) return false;

        ArmorItem armorItem = (ArmorItem) o;

        if (Double.compare(armorItem.getCost(), getCost()) != 0) return false;
        if (getWeight() != armorItem.getWeight()) return false;
        return getColor().equals(armorItem.getColor());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getCost());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getWeight();
        result = 31 * result + getColor().hashCode();
        return result;
    }
}