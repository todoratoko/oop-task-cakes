package cakes.clients;

import cakes.Bakery;
import cakes.util.Helper;

public class Corporate extends Client{
    private int discount;

    public Corporate(Bakery bakery) {
        super(bakery);
        this.discount = 100 - Helper.getRandom(5,16);
    }

    @Override
    public boolean hasTickets() {
        return false;
    }

    @Override
    protected int percentTip() {
        return 5;
    }

    @Override
    protected void removeTicketsValueFromOrderPrice(){

    }

    @Override
    protected int wantingCakesToOrder() {
        return Helper.getRandom(3,6);
    }

    public int getDiscount() {
        return discount;
    }



}
