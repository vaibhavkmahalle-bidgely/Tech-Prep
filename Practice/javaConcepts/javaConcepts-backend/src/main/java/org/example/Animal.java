package org.example;

import java.lang.reflect.Array;

class Animal {
    String color;
    int legs;
    short height;
    byte bite;
    long laung;
    double duble;
    char charvahak;
    float floating;
    boolean bull;
    Array[] array = {};

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public short getHeight() {
        return height;
    }

    public void setBite(byte bitten) {
        this.bite = bitten;
    }

    public byte getBite() {
        return bite;
    }


    public long getLaung() {
        return laung;
    }

    public void setLaung(long laung) {
        this.laung = laung;
    }

    public double getDuble() {
        return duble;
    }

    public void setDuble(double duble) {
        this.duble = duble;
    }

    public char getCharvahak() {
        return charvahak;
    }

    public void setCharvahak(char charvahak) {
        this.charvahak = charvahak;
    }

    public float getFloating() {
        return floating;
    }

    public void setFloating(float floating) {
        this.floating = floating;
    }

    public boolean isBull() {
        return bull;
    }

    public void setBull(boolean bull) {
        this.bull = bull;
    }

    public Boolean getBull() {
        return bull;
    }

    public Array[] getArray() {
        return array;
    }

    public void setArray(Array[] array) {
        this.array = array;
    }
}
