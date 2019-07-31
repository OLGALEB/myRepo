package com.playtika;

import java.io.Serializable;

public class Knight implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Knight knight = (Knight) o;

        if (heathIndex != knight.heathIndex) return false;
        if (name != null ? !name.equals(knight.name) : knight.name != null) return false;
        if (armor != null ? !armor.equals(knight.armor) : knight.armor != null) return false;
        return rank != null ? rank.equals(knight.rank) : knight.rank == null;
    }

    @Override
    public int hashCode() {
        int result = heathIndex;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (armor != null ? armor.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }
}