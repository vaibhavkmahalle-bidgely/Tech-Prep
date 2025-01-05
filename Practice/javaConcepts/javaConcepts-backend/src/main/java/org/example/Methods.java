package org.example;

public class Methods {
    Methods(){
        int a = 2;
    }
    public int sum(int a, int b){
       return a+b;
    }

    public int multiplication(int a, int b, int c ){
        return sum(a,b)*c;
    }

    public static void main(String[] args) {
        Methods methodsObject = new Methods();

        System.out.println(methodsObject.sum(2,3));
        System.out.println(methodsObject.multiplication(2,2,3));
    }
}
