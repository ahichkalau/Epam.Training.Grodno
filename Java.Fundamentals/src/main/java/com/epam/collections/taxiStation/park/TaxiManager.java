package com.epam.collections.taxiStation.park;

import com.epam.collections.taxiStation.car.Car;
import com.epam.collections.taxiStation.taxiException.TaxiStationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaxiManager {
    ArrayList<Car> taxiArray = new ArrayList<Car>();

    public TaxiManager(Car ... cars) {
        for (Car currentCar : cars){
            taxiArray.add(currentCar);
        }
    }

    public void addCarToPark(Car addedCar){
       taxiArray.add(addedCar);
    }

    public void addCarToPark(Car ... addedCar){
        for (int i = 0; i < addedCar.length; i++) {
            taxiArray.add(addedCar[i]);
        }
    }

    public void removeCarFromPark(Car removableCar){
        taxiArray.remove(removableCar);
    }

    public void calculateCostOfAllCarInPark(){
        int costOfAllCarInPArk = 0;
        for (int i = 0; i < taxiArray.size(); i++) {
            costOfAllCarInPArk += taxiArray.get(i).getCarCost();
        }
        System.out.println("Стоимость всех машин автопарка составляет " + costOfAllCarInPArk);
        System.out.println();
    }

    public void findCarInSelectedSpeedRange(int minimalSpeed, int maximumSpeed) throws TaxiStationException{
        if (minimalSpeed <= 0 || maximumSpeed <= 0){
            throw new TaxiStationException("Скорость не может быть меньше либо равна 0");
        }
        if (minimalSpeed >= maximumSpeed){
            throw new TaxiStationException("Минимальная скорость не может быть больше либо равна максимальной");
        }
        System.out.println("Машины в выбранном диапазоне скоростей(от " + minimalSpeed + " до" + " " + maximumSpeed + " )");

        for (int i = 0; i < taxiArray.size(); i++) {
            int checkedCarSpeed = taxiArray.get(i).getMaximumSpeed();
            if (checkedCarSpeed >= minimalSpeed && checkedCarSpeed <= maximumSpeed){
                System.out.println(taxiArray.get(i));
            }
        }
        System.out.println();
    }

    public void sortCarByFuelConsumption(){
        ArrayList<Car> sortedForFuelConsumptionArray = taxiArray;
        Collections.sort(sortedForFuelConsumptionArray, new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
            }
        }
        );
        System.out.println("Автопарк, отсортированный по расходу топлива");
        for (int i = 0; i < sortedForFuelConsumptionArray.size(); i++) {
            System.out.println(sortedForFuelConsumptionArray.get(i));
        }
        System.out.println();
    }

}
