package com.playtika;


public class Knight {
    public final int heathIndex;
    public final String name;
    public final Armor armor;
    public final String rank;

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