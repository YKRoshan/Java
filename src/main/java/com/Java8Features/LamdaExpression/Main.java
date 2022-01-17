package com.Java8Features.LamdaExpression;

public class Main {
    public static void main(String[] args) {
        //1
        Calculator calc = new Calculator() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        int sum = calc.sum(10, 15);
        System.out.println(sum);

        //2
        Calculator calculator = (a1, b1) -> {
            return a1 + b1;
        };
        System.out.println(calculator.sum(5, 12));

        //3
        Calculator cal = (int c, int d) -> c + d;
        System.out.println(cal.sum(10, 20));

        //4
        Calculator c = (a, b) -> a + b;
        System.out.println(c.sum(15, 20));
    }
}
