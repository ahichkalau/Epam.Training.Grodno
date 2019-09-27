package com.test.planes;

import com.test.models.ClassificationLevel;
import com.test.models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes experimentalTypePlane;
    private ClassificationLevel planeClassificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalTypePlane = type;
        this.planeClassificationLevel = classificationLevel;
    }

    public ClassificationLevel getPlaneClassificationLevel(){
        return planeClassificationLevel;
    }

    public void setPlaneClassificationLevel(ClassificationLevel planeClassificationLevel){
        this.planeClassificationLevel = planeClassificationLevel;
    }

    @Override
    public boolean equals(Object comparedPlane) {
        return super.equals(comparedPlane);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" + "model='" + model + '\'' + '}';
    }
}
