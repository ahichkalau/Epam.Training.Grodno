package com.epam.collections.taxiStation.car;

import com.epam.collections.taxiStation.taxiException.TaxiStationException;

public class Bus extends Car {
    int passengerCapacity;
    int numberOfFloors;
    BusDimension busDimension;

    public Bus(CarBrand carBrand, String carModel, int carCost, double fuelConsumption, int maximumSpeed,
               int passengerCapacity, int numberOfFloors, BusDimension busDimension) throws TaxiStationException {
        super(carBrand, carModel, carCost, fuelConsumption, maximumSpeed);
        this.passengerCapacity = passengerCapacity;
        this.numberOfFloors = numberOfFloors;
        this.busDimension = busDimension;
    }

    @Override
    public String toString() {
        return carBrand + " " +  carModel  +
                ", стоимость " + carCost +
                ", расход топлива " + fuelConsumption +
                ", максимальная скорость " + maximumSpeed +
                ", пассажировместимость " + passengerCapacity +
                ", количество этажей " + numberOfFloors +
                ", размер автобуса " + busDimension.getDimensionName();

    }
}
