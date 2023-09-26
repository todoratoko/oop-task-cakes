package cakes;

import cakes.util.Helper;

public class Demo {
    public static void main(String[] args) {
        Bakery bakery = new Bakery("PriToko", "Sofia, Mladost 1, ulitsa Nishava 4", 5);
        bakery.fillWithCakes(30);
       bakery.showCatalogue();
        bakery.fillWithClients(10);
        bakery.clientsOrderAndPay();
        System.out.println("=====================");
        bakery.showCatalogue();
        System.out.println("=====================");
        System.out.println("The $ of the bakery after the sales is : " + bakery.cash);
        System.out.println("=====================");
        bakery.showWorkersByPrice();
        System.out.println("=====================");
        bakery.showWorkersByFinishedOrders();
        System.out.println("=====================");
        bakery.showClientWhoPayedMostForOrder();




    }

}
