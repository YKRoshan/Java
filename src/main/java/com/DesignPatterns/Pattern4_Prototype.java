package com.DesignPatterns;

import java.util.ArrayList;

/*
Properties:
1.Creational design pattern
2.Used when we want to avoid multiple object creation of same
instance, instead you copy the object to new object & then we can
modify as per our need.

Implementation:
1.Object which we're copying should provide copying feature by
implementation cloneable interface.
2.We can override clone() method to implement as per our need.
*/
public class Pattern4_Prototype {
    public static void main(String[] args) {
        Vehicle2 a = new Vehicle2();
        a.insertData();

        Vehicle2 b = (Vehicle2) a.clone();
        b.getVehicleList().add("Honda");

        System.out.println(a.vehicleList);
        System.out.println(b.vehicleList);

    }
}

class Vehicle2 implements Cloneable {
    ArrayList<String> vehicleList;

    public Vehicle2() {
        this.vehicleList = new ArrayList<>();
    }

    public Vehicle2(ArrayList<String> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public ArrayList<String> getVehicleList() {
        return vehicleList;
    }

    public void insertData() {
        vehicleList.add("car");
        vehicleList.add("bike");
        vehicleList.add("Bicycle");
    }

    @Override
    public Object clone() {
        ArrayList<String> list = new ArrayList<>();
        for (String s : vehicleList) {
            list.add(s);
        }
        return new Vehicle2(list);
    }
}
