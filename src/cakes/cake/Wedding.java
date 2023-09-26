package cakes.cake;

import cakes.util.Helper;

public class Wedding extends Cake implements Comparable<Cake>{
    private int floors;
    String[] listOfKindTypes = {"Goliama", "Malka", "Sredna"};

    public int getFloors() {
        return floors;
    }

    public String getCakeType() {
        return "Wedding";
    }

    public Wedding() {
        super();
        this.cakeKind = this.listOfKindTypes[Helper.getRandom(this.listOfKindTypes.length)];
    }

    @Override
    public int compareTo(Cake o) {
        if(this.getPieces() == o.getPieces()){
            return 1;
        }
        return o.getPieces() - this.getPieces();
    }
}
