package cakes;

import cakes.cake.Cake;
import cakes.clients.Client;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Client client;
    public int price;
    private String orderAddress;
    public ArrayList<Cake> orderedCakes;
    public Worker worker;
    private LocalDateTime finishedTime;

    public Order(Client client) {
        this.client = client;
        this.orderedCakes = new ArrayList<>();
        this.finishedTime = LocalDateTime.now();
    }

    public int getPrice() {
        return this.price;
    }

    public Client getClient() {
        return this.client;
    }
}
