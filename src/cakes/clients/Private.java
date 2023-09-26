package cakes.clients;

import cakes.Bakery;
import cakes.util.Helper;

import java.util.ArrayList;

public class Private extends Client {
    ArrayList<Integer> coupons; // in constructor create from 1 to 4., each coupon can return randomly from 10 to 30$

    // in method pay, another method give all coupons where depending on number of coupons that times remove from 10 to 30$

    public Private(Bakery bakery) {
        super(bakery);
        this.coupons = new ArrayList<>();
        setCoupons();
    }

    @Override
    public boolean hasTickets() {
        return true;
    }

    @Override
    protected int percentTip() {
        return 2;
    }

    @Override
    protected int getDiscount() {
        return 100;
    }

    @Override
    protected void removeTicketsValueFromOrderPrice() {
        for (int i = 0; i < coupons.size(); i++) {
            order.price -= coupons.get(i);
        }
    }

    @Override
    protected int wantingCakesToOrder() {
        return Helper.getRandom(1, 4);
    }


    private void setCoupons() {
        int numberOfCoupons = Helper.getRandom(1, 4);
        for (int i = 0; i < numberOfCoupons; i++) {
            int valueOfCoupon = Helper.getRandom(10, 30);
            coupons.add(valueOfCoupon);
        }
    }

    public int getNumberOfCoupons() {
        return coupons.size();
    }
}
