package com.DesignPatterns;

/*
Properties:
1.Creational design pattern
2.Used when we have too many arguments to send in constructor & it's
hard to maintain the order.
3.When we don't want to send all parameters in object initialisation

Implementation:
1.We create a 'static nested class', which contains all arguments of
outer class.
2.As per naming conversation, if class name is 'Vehicle', builder class
should be 'VehicleBuilder'.
3.Builder class have a public constructor with all required parameters.
4.Builder class should have methods for optional parameters.Method will
return the builder object.
5.A 'build()' method that will return the final object.
6.The main class 'Vehicle' has private constructor so to create instance
only via Builder class.
7.The main class 'Vehicle' has only getters.
*/
public class Pattern3_Builder {
    public static void main(String[] args) {
        Vehicle1 car = new Vehicle1.VehicleBuilder("1500cc", 4).setAirbags(2).build();
        Vehicle1 bike = new Vehicle1.VehicleBuilder("400cc", 4).build();
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}

class Vehicle1 {
    //Required parameter
    private String engine;
    private int wheel;
    //Optional parameter
    private int airbags;

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }

    public Vehicle1(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle1 build() {
            return new Vehicle1(this);
        }
    }
}



