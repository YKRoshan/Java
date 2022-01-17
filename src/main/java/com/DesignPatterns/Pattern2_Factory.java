package com.DesignPatterns;

/*
Properties:
1.Creational design pattern
2.Used when we have multiple sub-classes of a super class & based on
  input we want to return one class instance
3.It provides abstraction between implementation & client classes
4.Remove the instantiation of client classes from client code
 */
public class Pattern2_Factory {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(car.toString());
        System.out.println(bike.toString());
    }
}

abstract class Vehicle {
    abstract int getWheel();

    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

class Car extends Vehicle {
    int wheel;

    public Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    int getWheel() {
        return wheel;
    }
}

class Bike extends Vehicle {
    int wheel;

    public Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    int getWheel() {
        return wheel;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if (type.equals("car")) {
            return new Car(wheel);
        } else if (type.equals("bike")) {
            return new Bike(wheel);
        } else return null;
    }
}
