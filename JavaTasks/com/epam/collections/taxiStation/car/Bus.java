package com.epam.collections.taxiStation.car;

import com.epam.collections.taxiStation.taxiException.TaxiStationException;

public class Bus extends Car {
    int passengerCapacity;
    int numberOfFloors;

    public Bus(CarBrand carBrand, String carModel, int carCost, double fuelConsumption, int maximumSpeed,
               int passengerCapacity, int numberOfFloors) throws TaxiStationException {
        super(carBrand, carModel, carCost, fuelConsumption, maximumSpeed);
        this.passengerCapacity = passengerCapacity;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", пассажировместимость " + passengerCapacity +
                ", количество этажей " + numberOfFloors
                ;
    }
}
