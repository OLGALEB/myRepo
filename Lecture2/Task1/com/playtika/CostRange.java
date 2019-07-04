package com.playtika;

public class CostRange {
    private final int minCost;
    private final int maxCost;

    public CostRange(int minCost, int maxCost) {
        this.minCost = minCost;
        this.maxCost = maxCost;
    }

    public int getMinCost() {
        return minCost;
    }

    public int getMaxCost() {
        return maxCost;
    }
}