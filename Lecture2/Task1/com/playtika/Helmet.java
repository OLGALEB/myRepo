package com.playtika;

public class Helmet extends ArmorItem {

    private final String color;
    private final int protectionLevel;
    private final HelmType helmType;


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
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}