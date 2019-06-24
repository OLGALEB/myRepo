package com.playtika;

public class Boot extends Item {

    public  final String color;
    public  final int protectionLevel;


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
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}