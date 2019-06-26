package com.playtika;

public class Helmet extends ArmorItem {

    public final String color;
    public final int protectionLevel;
    public final HelmType helmType;


    public Helmet(String color, HelmType helmType, int protectionLevel, int cost, int weight) {
        super(cost, weight);
        this.color = color;
        this.protectionLevel = protectionLevel;
        this.helmType = helmType;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "color='" + color + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", helmType='" + helmType + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}

