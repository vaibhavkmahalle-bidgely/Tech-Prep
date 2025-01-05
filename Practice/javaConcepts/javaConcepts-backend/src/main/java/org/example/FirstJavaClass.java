package org.example;

public class FirstJavaClass {
//    String color;
//    int legs;
//    short height;
//    byte bite;
//    long laung;
//    double duble;
//    char charvahak;
//    float floating;
//    boolean bull;
//    Array[] array = {};
    public static void main(String[] args) {

        Animal Dog = new Animal();
        System.out.printf("Dog color: %s, Dog legs: %d, Dog Height:  %d, Dog bite: %d, Dog laung: %d, Dog duble: %f, Dog charvahak: %c, Dog floating: %f, Dog Boolean: %b",Dog.getColor(), Dog.getLegs(), Dog.getHeight(), Dog.getBite(), Dog.getLaung(), Dog.getDuble(), Dog.getCharvahak(), Dog.getFloating(), Dog.getBull());

    }
}
