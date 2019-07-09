package com.playtika.task1.lecture3;


public class Knight {
    private final int heathIndex;
    private final String name;
    private final Armor armor;
    private final String rank;

    public Knight(int heathIndex, String name, Armor armor, String rank) {
        this.heathIndex = heathIndex;
        this.name = name;
        this.armor = armor;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "heathIndex=" + heathIndex +
                ", name='" + name + '\'' +
                ", armor=" + armor +
                ", rank='" + rank + '\'' +
                '}';
    }
}