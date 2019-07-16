package com.playtika;

public class Sword extends ArmorItem {

    private int damageCaused;
    private int sharpness;
    static final int DEFAULT_DAMAGE_CAUSED = 25;
    static final int DEFAULT_SHARPNESS = 17;

    public Sword(int damageCaused, int sharpness, double cost, int weight, String color) {
        super(cost, weight, color);
        this.damageCaused = damageCaused;
        this.sharpness = sharpness;
    }

    public Sword(double cost, int weight, String color) {
        this(DEFAULT_DAMAGE_CAUSED, DEFAULT_SHARPNESS, cost, weight, color);
    }

    @Override
    public String toString() {
        return "Sword{" +
                "color='" + getColor() + '\'' +
                ", damageCaused=" + damageCaused +
                ", sharpness=" + sharpness +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}