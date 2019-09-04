package com.sda.generics;

public class Garage<T extends AVehicle> {

    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    public void repair(){
        this.vehicle.repair();
    }
}
