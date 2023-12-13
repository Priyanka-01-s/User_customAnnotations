package com.example;

public class Main {
    public static void main(String[] args) throws ValiadationException {
        System.out.println("----------------CUSTOM ANNOTATION FOR USER VALIDATION---------------");

        User user = new User("Priyanka Sengupta", "Hello123", 21);
        System.out.println("\nValiadation for user1");
        try {
            Validation.validate(user);
            System.out.println("Validation passed.");
        } catch (ValiadationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        User user2 = new User("priyanka132", "root", -10);
        System.out.println("\nValiadation for user2");

        try {
            Validation.validate(user2);
            System.out.println("Validation passed.");
        } catch (ValiadationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        User user3 = new User("", "root", 10);
        System.out.println("\nValiadation for user3");
        try {
            Validation.validate(user3);
            System.out.println("Validation passed.");
        } catch (ValiadationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

    }
}