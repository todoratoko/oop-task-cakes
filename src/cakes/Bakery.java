package cakes;

import cakes.cake.Cake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Bakery {
    private String name;
    private String address;
    private String contactNumber;
    private TreeSet<Worker> workers; //sorted by getTips, decreasing
    private HashMap<String, HashMap<String, ArrayList<Cake>>> catalogue;

}
