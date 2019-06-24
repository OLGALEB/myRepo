package com.playtika;

public class Sword extends Item {

    public final String color;
    public final int damageCaused;
    public final int sharpness;


    public Sword(String color, int damageCaused, int sharpness, int cost, int weight) {
        super(cost, weight);
        this.color = color;
        this.damageCaused = damageCaused;
        this.sharpness = sharpness;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "color='" + color + '\'' +
                ", damageCaused=" + damageCaused +
                ", sharpness=" + sharpness +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}