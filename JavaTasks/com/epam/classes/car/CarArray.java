package com.epam.classes.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class CarArray {
    ArrayList<Car> carArray = new ArrayList();

    public CarArray(Car ... cars) {
        carArray.addAll(new ArrayList<>(Arrays.asList(cars)));
    }

    public ArrayList getCarArray() {
        return carArray;
    }


    public ArrayList<Car> addCarToArrayList(Car addCar){
        carArray.add(addCar);
        return carArray;
    }

    public String outputCarWithChoosedBrandName(CarBrand carBrand){
        String outputStringWithCarWithOneBrandName = "";
        for (int i = 0; i < carArray.size(); i++) {
            if (carArray.get(i).carBrand == carBrand){
                outputStringWithCarWithOneBrandName += carArray.get(i) + "\n";
            }
        }
        return outputStringWithCarWithOneBrandName;
    }

    public String outputCarWithSaidYearOfIssueAndMorePrice(int yearOfIssue, int cost) {
        String outputString = "";
        for (int i = 0; i < carArray.size(); i++) {
            Car checkedCar = carArray.get(i);
            if (checkedCar.yearOfIssue == yearOfIssue && checkedCar.cost > cost){
                outputString += checkedCar + "\n";
            }
        }
        return outputString;
    }

    public String outputCarWithOneModelAndMoreUsageTime(String model, int usageTime){
        String outputString = "";
        for (int i = 0; i < carArray.size(); i++) {
            Car checkedCar = carArray.get(i);
            if (checkedCar.carModel.equalsIgnoreCase(model)
                    && checkedCar.yearOfIssue < (Calendar.getInstance().get(Calendar.YEAR) - usageTime )){
                outputString += checkedCar + "\n";
            }
        }
        return outputString;
    }

    @Override
    public String toString() {
        String carArrayInString = "";
        for (int i = 0; i < getCarArray().size(); i++) {
            carArrayInString += carArray.get(i).toString() + "\n";
        }
        return carArrayInString;
    }
}
