package com.playtika;

public class Cuirass extends ArmorItem {

    private final String color;
    private final int protectionLevel;

    public Cuirass(String color, int protectionLevel, int cost, int weight) {
        super(cost, weight);
        this.color = color;
        this.protectionLevel = protectionLevel;
    }

    @Override
    public String toString() {
        return "Cuirass{" +
                "color='" + color + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}