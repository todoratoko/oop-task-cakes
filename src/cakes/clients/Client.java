package cakes.clients;

import cakes.Bakery;
import cakes.Order;
import cakes.cake.*;
import cakes.util.Helper;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Client {
    String[] listOfNames = {"Gosho", "Tosho", "Losho", "Bobi", "Niki", "Vanko", "Ivan", "Bobkata", "Lotkata"};
    private String name;
    private String phoneNumber;
    Bakery bakery;
    public Order order;

    public Client(Bakery bakery) {
        this.name = getRandomName();
        this.bakery = bakery;
    }

    public abstract boolean hasTickets();

    private String getRandomName() {
        return listOfNames[Helper.getRandom(listOfNames.length)];
    }


    public void orderCakes() {
        Order order = new Order(this);
        this.order = order;
        Cake cake;
        for (int i = 0; i < wantingCakesToOrder(); i++) {
            int chance = Helper.getRandom(100);
            if (chance < 25) {
                cake = new Kids();
            } else if (chance < 50) {
                cake = new Special();
            } else if (chance < 75) {
                cake = new Standard();
            } else {
                cake = new Wedding();
            }
            order.worker = bakery.getRandomWorker();
            if (this.bakery.checkIfCakeIsAvailableInMenu(cake)) {
                order.orderedCakes.add(cake);
                    this.bakery.soldCakes.put(cake.getCakeKind(), cake.incrementSoldCountAndGet());

            }
            else {
                break;
            }
            order.price += cake.getPrice();
        }

        if (hasTickets()) {
            removeTicketsValueFromOrderPrice();
        }
        order.price -= (order.price * getDiscount()) / 100;
        bakery.cash += order.price;
        order.worker.cashFromTips += (order.price * percentTip()) / 100;
        order.worker.numberOfFinishedOrders++;

    }

    protected abstract int percentTip();

    protected abstract int getDiscount();


    protected abstract void removeTicketsValueFromOrderPrice();


    protected abstract int wantingCakesToOrder();

    public String getName() {
        return name;
    }

    public int getOrderPrice() {
        return order.price;
    }

    public Order getOrder() {
        return order;
    }
}
