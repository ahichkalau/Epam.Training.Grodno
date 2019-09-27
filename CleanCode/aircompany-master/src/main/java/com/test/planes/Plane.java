package com.test.planes;

import java.util.Objects;

abstract public class Plane {
    String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String planeModel, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = planeModel;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getplaneModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        int maxLoadCapacity = this.maxLoadCapacity;
        return maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" + "model='" + model + '\'' +  ", maxSpeed=" + maxSpeed
                + ", maxFlightDistance=" + maxFlightDistance + ", maxLoadCapacity="
                + maxLoadCapacity + '}';
    }

    @Override
    public boolean equals(Object comparedPlane) {
        if (this == comparedPlane) return true;
        if (!(comparedPlane instanceof Plane)) return false;
        Plane initialPlane = (Plane) comparedPlane;
        return maxSpeed == initialPlane.maxSpeed &&  maxFlightDistance == initialPlane.maxFlightDistance
                && maxLoadCapacity == initialPlane.maxLoadCapacity && Objects.equals(model, initialPlane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
