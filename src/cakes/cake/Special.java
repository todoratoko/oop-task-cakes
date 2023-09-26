package cakes.cake;

import cakes.util.Helper;

public class Special extends Cake implements Comparable<Cake>{
    private String nameOfEvent;
    String[] listOfKindTypes = {"Iubuleina", "Firmena", "Reklamna"};

    public Special() {
        super();
        this.cakeKind = this.listOfKindTypes[Helper.getRandom(this.listOfKindTypes.length)];
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public String getCakeType() {
        return "Special";
    }

    @Override
    public int compareTo(Cake o) {
        if(this.getPrice() == o.getPrice()){
            return 1;
        }
        return o.getPrice() - this.getPrice();
    }
}
