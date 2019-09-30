package com.epam.classes;

import com.epam.classes.car.Car;
import com.epam.classes.car.CarArray;
import static com.epam.classes.car.CarBrand.*;

public class Main {
    public static void main(String[] args) {
        CarArray carArray = new CarArray(
                new Car(AUDI, "A4", 2003,"Black", 5000, "9474 BK-4"),
                new Car(MERCEDES_BENZ, "ML", 2005,"White", 9000,"5432 AE-1"),
                new Car(MERCEDES_BENZ, "GL", 2009,"Yellow", 12000,"5432 AK-6"),
                new Car(MERCEDES_BENZ, "CLS", 2015,"Red", 32000,"9872 AT-4"),
                new Car(AUDI, "A6", 2003,"blue", 4000,"5432 AC-6"),
                new Car(MAZDA, "6", 2010,"Black", 6000,"9876 BK-1"),
                new Car(RENAULT, "Logan", 2014,"Yellow", 9000,"4363 CK-7"),
                new Car(CITROEN, "C5", 2003,"Silver", 7000,"2132 MT-3"),
                new Car(DODGE, "Stratus", 2003,"Orange", 7000,"8392 LP-3"),
                new Car(FORD, "Focus", 2012,"Blue", 7000,"8642 AK-5"));
        System.out.println(carArray.outputCarWithChoosedBrandName(MERCEDES_BENZ));
        System.out.println(carArray.outputCarWithSaidYearOfIssueAndMorePrice(2003,3000));
        System.out.println(carArray.outputCarWithOneModelAndMoreUsageTime("A6", 13));
    }
}
