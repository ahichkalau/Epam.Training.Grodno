package com.epam.collections.taxiStation;


import com.epam.collections.taxiStation.car.*;
import com.epam.collections.taxiStation.park.TaxiManager;
import com.epam.collections.taxiStation.taxiException.TaxiStationException;

/*10. Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Подсчитать стоимость автопарка.
 Провести сортировку автомобилей парка по расходу топлива. Найти автомобиль в компании, соответствующий заданному
 диапазону параметров скорости.*/
public class Main {
    public static void main(String[] args) throws TaxiStationException {
        TaxiManager grodnoTaxiStation = new TaxiManager();
        Car car1 = new Car(CarBrand.AUDI, "A6",7000, 7.4, 210);
        Car car2 = new Car(CarBrand.BMW, "320",5400, 12.4, 240);
        Car car3 = new Car(CarBrand.FORD, "Focus",4300, 5.1, 130);
        Car car4 = new Car(CarBrand.CITROEN, "C5",6900, 5.3, 180);
        Car car5 = new Car(CarBrand.GEELY, "Atlas",13000, 12.7, 190);
        Car car6 = new Car(CarBrand.KIA, "Rio",5900, 6.3, 180);
        Car car7 = new Car(CarBrand.VOLKSWAGEN, "Polo",7400, 5.2, 190);
        Car car8 = new Car(CarBrand.VOLKSWAGEN, "Polo",7000, 5.3, 190);
        Bus bus1 = new Bus(CarBrand.VOLKSWAGEN,"T4", 16000, 15.7, 170, 15, 1, BusDimension.SMALL);
        Bus bus2 = new Bus(CarBrand.VOLKSWAGEN,"T5", 25000, 12.7, 180, 15, 1, BusDimension.SMALL);
        Car cargo1 = new Cargo(CarBrand.VOLKSWAGEN,"Caddy",22100, 8.3, 190,815, 3);
        Car cargo2 = new Cargo(CarBrand.VOLKSWAGEN,"Crafter",34100, 9.5, 180,1675, 7);

        grodnoTaxiStation.addCarToPark(car1, car2, car3, car4, car5, car6, car7, car8, bus1,bus2, cargo1, cargo2);
        grodnoTaxiStation.calculateCostOfAllCarInPark();
        grodnoTaxiStation.findCarInSelectedSpeedRange(120, 150);
        grodnoTaxiStation.sortCarByFuelConsumption();
    }
}
