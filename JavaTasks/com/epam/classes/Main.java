package com.epam.classes;

import com.epam.classes.car.Car;
import com.epam.classes.car.CarArray;
import com.epam.classes.car.CarBrand;

public class Main {
    public static void main(String[] args) {
        Car testCar = new Car(CarBrand.AUDI, "A4", 2003,"Black", 5000, "9474 BK-4");
        CarArray carArray = new CarArray();
        carArray.addCarToArrayList(testCar);
        carArray.addCarToArrayList(new Car(CarBrand.MERCEDES_BENZ, "ML", 2005,"White", 9000,"5432 AE-1"));
        carArray.addCarToArrayList(new Car(CarBrand.MERCEDES_BENZ, "GL", 2009,"Yellow", 12000,"5432 AK-6"));
        carArray.addCarToArrayList(new Car(CarBrand.MERCEDES_BENZ, "CLS", 2015,"Red", 32000,"9872 AT-4"));
        carArray.addCarToArrayList(new Car(CarBrand.AUDI, "A6", 2003,"blue", 4000,"5432 AC-6"));
        carArray.addCarToArrayList(new Car(CarBrand.MAZDA, "6", 2010,"Black", 6000,"9876 BK-1"));
        carArray.addCarToArrayList(new Car(CarBrand.RENAULT, "Logan", 2014,"Yellow", 9000,"4363 CK-7"));
        carArray.addCarToArrayList(new Car(CarBrand.CITROEN, "C5", 2003,"Silver", 7000,"2132 MT-3"));
        carArray.addCarToArrayList(new Car(CarBrand.DODGE, "Stratus", 2003,"Orange", 7000,"8392 LP-3"));
        carArray.addCarToArrayList(new Car(CarBrand.FORD, "Focus", 2012,"Blue", 7000,"8642 AK-5"));
        System.out.println(carArray.outputCarOneBrandName(CarBrand.MERCEDES_BENZ));
        System.out.println(carArray.outputCarWithSaidYearOfIssueAndMorePrice(2003,3000));
        System.out.println(carArray.outputCarWithOneModelAndMoreUsageTime("A6", 13));
    }
}
