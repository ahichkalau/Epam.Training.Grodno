package com.epam.thread.trainstation;

public enum CarBrand {
    AUDI("Audi"), BMW("BMW"), CITROEN("Citroen"), DODGE("Dodge"),
    FIAT("Fiat"), FORD("Ford"), GEELY("Geely"), HONDA("Honda"),
    KIA("Kia"), MAZDA("Mazda"), MERCEDES_BENZ("Mercedes-Benz"),
    OPEL("Opel"), RENAULT("Renault"),VOLKSWAGEN("Volkswagen");

    String carBrandName;

    CarBrand(String carBrandName) {
        this.carBrandName = carBrandName;
    }
}
