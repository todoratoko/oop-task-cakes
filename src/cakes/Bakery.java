package cakes;

import cakes.cake.*;
import cakes.clients.Client;
import cakes.clients.Corporate;
import cakes.clients.Private;
import cakes.util.Helper;

import java.util.*;

public class Bakery {
    private String name;
    private String address;
    private String contactNumber;
    private TreeSet<Worker> workers; //sorted by getTips, decreasing

    //          CakeType , < CakeKind , Object Cakes >
    public HashMap<String, HashMap<String, ArrayList<Cake>>> catalogue;

    private ArrayList<Client> clients;
    public int cash;
    public HashMap<String, Integer> soldCakes;


    public Bakery(String name, String address, int workers) {
        this.name = name;
        this.address = address;
        this.workers = new TreeSet<>();
        for (int i = 0; i < workers; i++) {
            this.workers.add(new Worker());
        }
        this.catalogue = new HashMap<>();
        this.clients = new ArrayList<>();
        this.soldCakes = new HashMap<>();
    }

    public void fillWithCakes(int numbOfCakes) {
        Cake cake;
        for (int i = 0; i < numbOfCakes; i++) {
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
            addCakeInMenu(cake);
        }

    }

    private void addCakeInMenu(Cake cake) {
        if (!catalogue.containsKey(cake.getCakeType())) {
            catalogue.put(cake.getCakeType(), new HashMap<>());
        }
        if (!catalogue.get(cake.getCakeType()).containsKey(cake.getCakeKind())) {
            catalogue.get(cake.getCakeType()).put(cake.getCakeKind(), new ArrayList<>());
        }
        catalogue.get(cake.getCakeType()).get(cake.getCakeKind()).add(cake);
    }

    public void fillWithClients(int numbOfClients) {
        for (int i = 0; i < numbOfClients / 2; i++) {
            this.clients.add(new Corporate(this));
            this.clients.add(new Private(this));
        }
    }

    public void clientsOrderAndPay() {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).orderCakes();
        }
    }

    public boolean checkIfCakeIsAvailableInMenu(Cake cake) {
        if (catalogue.containsKey(cake.getCakeType())) {
            if (catalogue.get(cake.getCakeType()).containsKey(cake.getCakeKind())) {
                catalogue.get(cake.getCakeType()).get(cake.getCakeKind()).remove(cake);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Worker getRandomWorker() {
        int rand = Helper.getRandom(workers.size());
        int counter = 0;
        for (Worker s : workers) {
            if (counter++ == rand) {
                return s;
            }
        }
        return null;
    }

    public void showCatalogue() {
        System.out.println("The current available cakes form the catalogue: ");
        for (Map.Entry<String, HashMap<String, ArrayList<Cake>>> a : catalogue.entrySet()) {
            System.out.println("Type of cakes " + a.getKey() + " :");
            for (Map.Entry<String, ArrayList<Cake>> a1 : a.getValue().entrySet()) {
                System.out.println(a1.getKey() + " with a number of -" + a1.getValue().size());
            }
        }
    }

    public void showWorkersByPrice() {
        workers.stream().sorted(Comparator.comparingInt(Worker::getCashFromTips).reversed()).forEach(a -> System.out.println(a.getName() + " with tip of : " + a.getCashFromTips()));
    }

    public void showWorkersByFinishedOrders() {
        System.out.println(workers.stream().sorted(Comparator.comparingInt(Worker::getNumberOfFinishedOrders).reversed()).findFirst().get().toString());
    }

    public void showClientWhoPayedMostForOrder() {
        Order maxOrder = null;
        for(Client c: clients) {
            if(maxOrder == null || maxOrder.getPrice() < c.getOrderPrice())
                    maxOrder = c.getOrder();
        }
        System.out.println(maxOrder.getClient().getName() + " is the client with bigges order of value of : " + maxOrder.getPrice());
    }

    public void showTypeOfCakesWithMostSales() {
        for (Map.Entry<String, Integer> v : soldCakes.entrySet()) {
            System.out.println(v.getKey() + " with sales of : " + v.getValue());
        }

    }


}
