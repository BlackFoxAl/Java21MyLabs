package org.cadenhead.ecommerce;

public class GiftShop2 {
    public static void main(String[] arguments) {
        StoreFront2 store = new StoreFront2();
        store.addItem("C01","MUG","9.99","150","true");
        store.addItem("C02","LG MUG","12.99","82","false");
        store.addItem("C03","MOUSEPAD","10.49","800","true");
        store.addItem("D01","T SHIRT","16.99","90","false");
        store.sort();

        for (int i = 0; i < store.getSize(); i++) {
            Item2 show = (Item2) store.getItem(i);
            System.out.println("\nItem ID: " + show.getId() +
                    "\nName: " + show.getName() +
                    "\nRetail Price: " + show.getRetail() +
                    "\nPrice: $" + show.getPrice() +
                    "\nQuantity: " + show.getQuantity() +
                    "\nnoDiscount: " + show.isNoDiscount());
        }

    }
}
