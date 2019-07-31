package com.playtika;

public class Helmet extends ArmorItem {

    private int protectionLevel;
    private HelmType helmType;
    static final int DEFAULT = 13;


    public Helmet(int protectionLevel, HelmType helmType, double cost, int weight, String color) {
        super(cost, weight, color);
        this.protectionLevel = protectionLevel;
        this.helmType = helmType;
    }

    public Helmet(double cost, int weight, String color) {
        this(DEFAULT, HelmType.CLOSED, cost, weight, color);
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "color='" + getColor() + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", helmType='" + helmType + '\'' +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}