package com.Java8Features.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Customer customer = new Customer(1, null, "yash@gmail.com");

        //empty method will create empty optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);//Optional.empty

        // of method will throw NPE if value is null
        Optional<String> emailOptional = Optional.of(customer.getEmail());
        System.out.println(emailOptional.get());

        //ofNullable method will create empty optional if value is null otherwise optional of object
        Optional<String> nameOptional = Optional.ofNullable(customer.getName());
        System.out.println(nameOptional);

        //isPresent method will return true if value is present
        if (nameOptional.isPresent()) {
            System.out.println(nameOptional.get());
        }

        //if we want to provide default value if optional is empty then we can use orElse method
        System.out.println(nameOptional.orElse("Yash"));

        //map method is used to perform operation on optional object
        Optional<String> optional = Optional.of("yashawant");
        System.out.println(optional.map(String::toUpperCase).orElse("NoName"));

        //Optional with stream API
        List<Customer> list = new ArrayList<>();
        list.add(new Customer(2, "Roshan", null));
        list.add(new Customer(2, "Yashwant", "yash@gmail.com"));

        /*Optional<Customer> cus = list.stream().filter(customer1 -> customer1.getEmail()
            .equals("yashwant@gmail.com")).findAny();*/  //NPE

        System.out.println(list.stream().filter(customer1 -> customer1.getEmail()
            .equals("yashwant@gmail.com")).findAny().orElse(new Customer()));

    }
}
