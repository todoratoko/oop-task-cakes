package cakes;

import cakes.util.Helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Worker implements Comparable<Worker>{
    private String name;
    private String number;
    //not sure if hashset// for now the orders should be different
    HashSet<Order> ordersToDo;
    public int cashFromTips = 0;
    public int numberOfFinishedOrders;

    public Worker() {
        this.name = getRandomName();
        this.ordersToDo = new HashSet<Order>();
    }

    private String getRandomName(){
        return listOfNames[Helper.getRandom(listOfNames.length)];
    }

    String[] listOfNames = {"Gosho", "Tosho", "Losho", "Bobi", "Niki", "Vanko", "Ivan","Bobkata", "Lotkata"};

    public int getCashFromTips() {
        return cashFromTips;
    }

    @Override
    public String toString() {
        return  name + " with finished orders = " + numberOfFinishedOrders;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfFinishedOrders() {
        return numberOfFinishedOrders;
    }

    @Override
    public int compareTo(Worker o) {
        if(o.getCashFromTips() == this.getCashFromTips()){
            return 1;
        }
        return o.getCashFromTips() - this.getCashFromTips();
    }
}
