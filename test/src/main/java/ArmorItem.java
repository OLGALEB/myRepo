

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
}