package com.playtika;

public class Boot extends ArmorItem {

    private final int protectionLevel;
    static final int DEFAULT_PROTECTION_LEVEL = 10;

    public Boot(int protectionLevel, double cost, int weight, String color) {
        super(cost, weight, color);
        this.protectionLevel = protectionLevel;
    }

    public Boot(double cost, int weight, String color) {

        this(DEFAULT_PROTECTION_LEVEL, cost, weight, color);
    }

    @Override
    public String toString() {
        return "Boot{" +
                "color='" + getColor() + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}