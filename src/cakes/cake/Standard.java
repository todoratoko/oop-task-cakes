package cakes.cake;

import cakes.util.Helper;

public class Standard extends Cake implements Comparable<Cake>{
    boolean isSyroped;
    String[] listOfKindTypes = {"Biskvitena", "Eklerova", "Plodova", "Shokoladova"};

    public boolean isSyroped() {
        return this.isSyroped;
    }

    public String getCakeType() {
        return "Standard";
    }


    public Standard() {
        super();
        this.cakeKind = this.listOfKindTypes[Helper.getRandom(this.listOfKindTypes.length)];
    }

    @Override
    public int compareTo(Cake o) {
        return o.getPieces() - this.getPrice();
    }
}
