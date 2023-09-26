package cakes.cake;

import cakes.util.Helper;

public class Kids extends Cake implements Comparable<Cake>{
    private String nameOfKid;

    String[] listOfKindTypes = {"ZaRojdenDen", "ZaKrushtene", "ZaProshtapulnik"};

    public Kids() {
        super();
        this.cakeKind = this.listOfKindTypes[Helper.getRandom(this.listOfKindTypes.length)];
    }

    private String getNameOfKid() {
        return nameOfKid;
    }



    @Override
    public String getCakeType() {
        return "Kids";
    }


    @Override
    public int compareTo(Cake o) {
        if(this.getPieces() == o.getPieces()){
            return 1;
        }
        return o.getPieces() - this.getPieces();
    }
}
