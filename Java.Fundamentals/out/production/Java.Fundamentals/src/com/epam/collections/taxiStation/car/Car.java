package com.epam.collections.taxiStation.car;

import com.epam.collections.taxiStation.taxiException.TaxiStationException;

public class Car {
    CarBrand carBrand;
    String carModel;
    int carCost;
    double fuelConsumption;
    int maximumSpeed;

    public Car() {
    }

    public Car(CarBrand carBrand, String carModel, int carCost, double fuelConsumption, int maximumSpeed)
            throws TaxiStationException {
        this.carCost = carCost;
        this.fuelConsumption = fuelConsumption;
        this.maximumSpeed = maximumSpeed;
        this.carBrand = carBrand;
        this.carModel = carModel;
        if (carCost <= 0){
            throw new TaxiStationException("Стоимость машины не может быть меньше либо равна 0");
        }
        if (fuelConsumption <= 0){
            throw new TaxiStationException("Расход топлива не может быть меньше либо равен 0");
        }
        if (maximumSpeed <= 0){
            throw new TaxiStationException("Максимальная скорость машины не может быть меньше либо равна 0");
        }
    }

    public int getCarCost() {
        return carCost;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return   carBrand + " " +  carModel  +
                ", стоимость " + carCost +
                ", расход топлива " + fuelConsumption +
                ", максимальная скорость " + maximumSpeed;
    }
}
