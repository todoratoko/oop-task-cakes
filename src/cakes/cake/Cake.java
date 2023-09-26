package cakes.cake;

import cakes.util.Helper;

import java.util.Objects;

public abstract class Cake implements Comparable<Cake>{
    private String name;
    private String description;
    private int price;
    private int pieces;
    protected String cakeKind;
    private int soldCount = 0;

    public int getSoldCount() {
        return soldCount;
    }
    public int incrementSoldCountAndGet(){
        return ++this.soldCount;
    }

    public Cake() {
        this.price = Helper.getRandom(200,400);
        this.pieces = Helper.getRandom(6,14);
    }

    public abstract String getCakeType();

    public String getCakeKind(){
        return this.cakeKind;
    }

    public int getPieces() {
        return pieces;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return Objects.equals(cakeKind, cake.cakeKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cakeKind);
    }
}
