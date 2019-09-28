/*Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные
на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
Создать массив объектов. Вывести:
a) список автомобилей заданной марки;
b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
c) список автомобилей заданного года выпуска, цена которых больше указанной.*/


package com.epam.classes.car;

public class Car {
    public int id;
    public CarBrand carBrand;
    public String carModel;
    public int yearOfIssue;
    public String color;
    public int cost;
    public String registrationNumber;

    public Car() {
    }

    public Car(CarBrand carBrand, String carModel, int yearOfIssue) {
        this.id = carBrand.ordinal() * 31 + yearOfIssue + carModel.length() * 5;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.yearOfIssue = yearOfIssue;
    }

    public Car(CarBrand carBrand, String carModel, int yearOfIssue, String color, int cost, String registrationNumber) {
        this.id = carBrand.ordinal() * 31 + yearOfIssue + carModel.length() * 5;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.yearOfIssue = yearOfIssue;
        this.color = color;
        this.cost = cost;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", Марка=" + carBrand.getCarBrandName() +
                ", Модель=" + carModel +
                ", Год выпуска=" + yearOfIssue +
                ", Цвет=" + color +
                ", Стоимость=" + cost +
                ", Регистрационный номер=" + registrationNumber;
    }
}



