package com.playtika;

public class Boot extends ArmorItem {

    private final String color;
    private final int protectionLevel;

    public Boot(String color, int protectionLevel, int cost, int weight) {
        super(cost, weight);
        this.color = color;
        this.protectionLevel = protectionLevel;
    }

    @Override
    public String toString() {
        return "Boot{" +
                "color='" + color + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}