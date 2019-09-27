package com.test.planes;

import com.test.models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryType militaryTypePlane;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType typePlane) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryTypePlane = typePlane;
    }

    public MilitaryType getMilitaryTypePlane() {
        return militaryTypePlane;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", militaryTypePlane=" + militaryTypePlane + '}');
    }

    @Override
    public boolean equals(Object comparedPlane) {
        if (this == comparedPlane) return true;
        if (!(comparedPlane instanceof MilitaryPlane)) return false;
        if (!super.equals(comparedPlane)) return false;
        MilitaryPlane that = (MilitaryPlane) comparedPlane;
        return militaryTypePlane == that.militaryTypePlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryTypePlane);
    }
}
