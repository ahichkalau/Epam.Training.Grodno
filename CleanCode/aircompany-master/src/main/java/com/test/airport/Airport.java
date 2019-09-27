package com.test.airport;

import com.test.planes.ExperimentalPlane;
import com.test.models.MilitaryType;
import com.test.planes.MilitaryPlane;
import com.test.planes.PassengerPlane;
import com.test.planes.Plane;

import java.util.*;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends Plane> listWithAllPlanes = this.planes;
        List<PassengerPlane> listOfPassengerPlanes = new ArrayList<>();
        for (Plane comparedPlane : listWithAllPlanes) {
            if (comparedPlane instanceof PassengerPlane) {
                listOfPassengerPlanes.add((PassengerPlane) comparedPlane);
            }
        }
        return listOfPassengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> listOfMilitaryPlanes = new ArrayList<>();
        for (Plane comparedPlane : planes) {
            if (comparedPlane instanceof MilitaryPlane) {
                listOfMilitaryPlanes.add((MilitaryPlane) comparedPlane);
            } 
        } 
        return listOfMilitaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> listOfPassengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = listOfPassengerPlanes.get(0);
        for (int i = 0; i < listOfPassengerPlanes.size(); i++) {
            if (listOfPassengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = listOfPassengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> listOfTransportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> listOfMilitaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < listOfMilitaryPlanes.size(); i++) {
        MilitaryPlane createdListOfMilitaryPlanes = listOfMilitaryPlanes.get(i);
        if (createdListOfMilitaryPlanes.getMilitaryTypePlane() == MilitaryType.TRANSPORT) {
            listOfTransportMilitaryPlanes.add(createdListOfMilitaryPlanes);
        }
    }
        return listOfTransportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> listOfBomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane createdListOfMilitaryPlanes = militaryPlanes.get(i);
            if (createdListOfMilitaryPlanes.getMilitaryTypePlane() == MilitaryType.BOMBER) {
                listOfBomberMilitaryPlanes.add(createdListOfMilitaryPlanes);
            }
        }
        return listOfBomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> listOfExperimentalPlanes = new ArrayList<>();
        for (Plane comparedPlane : planes) {
            if (comparedPlane instanceof ExperimentalPlane) {
                listOfExperimentalPlanes.add((ExperimentalPlane) comparedPlane);
            }
        }
        return listOfExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firstComparedPlane, Plane secondComparedPlane) {
                return firstComparedPlane.getMaxFlightDistance() - secondComparedPlane.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firstComparedPlane, Plane secondComparedPlane) {
                return firstComparedPlane.getMaxSpeed() - secondComparedPlane.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firstComparedPlane, Plane secondComparedPlane) {
                return firstComparedPlane.getMaxLoadCapacity() - secondComparedPlane.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "com.test.airport.Airport{" + "Planes=" + planes.toString() + '}';
    }


}
