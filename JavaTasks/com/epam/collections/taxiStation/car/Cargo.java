package com.epam.collections.taxiStation.car;

import com.epam.collections.taxiStation.taxiException.TaxiStationException;

public class Cargo extends Car {
    int loadingCapacity;
    int compartmentVolume;

    public Cargo(CarBrand carBrand, String carModel, int carCost, double fuelConsumption, int maximumSpeed,
                 int loadingCapacity, int compartmentVolume) throws TaxiStationException {
        super(carBrand, carModel, carCost, fuelConsumption, maximumSpeed);
        this.loadingCapacity = loadingCapacity;
        this.compartmentVolume = compartmentVolume;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", грузоподъемность " + loadingCapacity +
                ", объем грузового отсека " + compartmentVolume
                ;
    }
}
