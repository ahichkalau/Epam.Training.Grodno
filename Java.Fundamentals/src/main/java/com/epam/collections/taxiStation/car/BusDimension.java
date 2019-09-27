package com.epam.collections.taxiStation.car;

public enum BusDimension {
    ESPECIALLY_SMALL("Очень маленький"), SMALL("Маленький"),
    MIDDLE_SIZED("Средний"), BIG("Большой");

    private String dimensionName;

    BusDimension(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public String getDimensionName() {
        return dimensionName;
    }
}
