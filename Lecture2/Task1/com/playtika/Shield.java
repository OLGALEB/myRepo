package com.playtika;

public class Shield extends ArmorItem {

    public final String color;
    public final int protectionLevel;

    public Shield(String color, int protectionLevel, int cost, int weight) {
        super(cost, weight);
        this.color = color;
        this.protectionLevel = protectionLevel;
    }

    @Override
    public String toString() {
        return "Shield{" +
                "color='" + color + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}
