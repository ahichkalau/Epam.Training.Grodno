package com.epam.collections.taxiStation;


import com.epam.collections.taxiStation.car.*;
import com.epam.collections.taxiStation.park.TaxiManager;
import com.epam.collections.taxiStation.taxiException.TaxiStationException;
import static com.epam.collections.taxiStation.car.CarBrand.*;

public class Main {
    public static void main(String[] args) throws TaxiStationException {
        TaxiManager grodnoTaxiStation = new TaxiManager(
                new Car(AUDI, "A6",7000, 7.4, 210),
                new Car(BMW, "320",5400, 12.4, 240),
                new Car(FORD, "Focus",4300, 5.1, 130),
                new Car(CITROEN, "C5",6900, 5.3, 180),
                new Car(GEELY, "Atlas",13000, 12.7, 190),
                new Car(KIA, "Rio",5900, 6.3, 180),
                new Car(VOLKSWAGEN, "Polo",7400, 5.2, 190),
                new Car(VOLKSWAGEN, "Polo",7000, 5.3, 190),
                new Bus(VOLKSWAGEN,"T4", 16000, 15.7, 170, 15, 1),
                new Bus(VOLKSWAGEN,"T5", 25000, 12.7, 180, 15, 1),
                new Bus(NEOPLAN,"122",33400,25.5,130,57,2),
                new Cargo(VOLKSWAGEN,"Caddy",22100, 8.3, 190,815, 3),
                new Cargo(VOLKSWAGEN,"Crafter",34100, 9.5, 180,1675, 7),
                new Cargo(MAZ, "5516", 23500, 23.2, 85, 20000, 18)
        );

        grodnoTaxiStation.calculateCostOfAllCarInPark();
        grodnoTaxiStation.findCarInSelectedSpeedRange(100, 140);
        grodnoTaxiStation.sortCarByFuelConsumption();
    }
}
