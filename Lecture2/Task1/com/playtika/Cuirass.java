package com.playtika;

public class Cuirass extends ArmorItem {

    public final String color;
    public final int protectionLevel;

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
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}




