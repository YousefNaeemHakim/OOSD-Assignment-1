import java.util.ArrayList;

public class coffeeShop {
    private String name;
    private ArrayList<String> menu;
    private ArrayList<String> orders;

    public coffeeShop(String name, ArrayList<String> menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<String>();
    }

    // Add more items to the menu if needed
    private static ArrayList<String> createMenu() {
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Coffee, 2.50, drink");
        menu.add("Tea, 2.00, drink");
        menu.add("Hot Chocolate, 3.00, drink");
        menu.add("Bagel, 2.50, food");
        menu.add("Croissant, 2.00, food");
        menu.add("Muffin, 1.50, food");
        return menu;
    }

    public void addOrder(String order) {
        this.orders.add(order);
        System.out.println("Added order: " + order);
    }

    public void fulfillOrder() {
        try {
            if (this.orders.size() > 0) {
                String order = this.orders.get(0);
                this.orders.remove(0);
                System.out.println("Fulfilled order: " + order);
            } else {
                throw new Exception("No orders to fulfill.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    public void listOrders() {
        if (this.orders.size() > 0) {
            System.out.println("Current orders:");
            for (String order : this.orders) {
                System.out.println(order);
            }
        } else {
            System.out.println("No orders.");
        }
    }

    public double dueAmount() {
        double total = 0;
        for (String order : this.orders) {
            String[] items = order.split(",");
            double price = Double.parseDouble(items[1].trim());
            total += price;
        }
        return total;
    }

    public String cheaperItem() {
        String cheapestItem = "";
        double cheapestPrice = Double.MAX_VALUE;
        for (String item : this.menu) {
            String[] parts = item.split(",");
            double price = Double.parseDouble(parts[1].trim());
            if (price < cheapestPrice) {
                cheapestItem = parts[0].trim();
                cheapestPrice = price;
            }
        }
        return cheapestItem;
    }

    public void drinksOnly() {
        System.out.println("Drinks:");
        for (String item : this.menu) {
            String[] parts = item.split(",");
            String type = parts[2].trim();
            if (type.equals("drink")) {
                System.out.println(parts[0].trim());
            }
        }
    }

    public void foodOnly() {
        System.out.println("Food:");
        for (String item : this.menu) {
            String[] parts = item.split(",");
            String type = parts[2].trim();
            if (type.equals("food")) {
                System.out.println(parts[0].trim());
            }
        }
    }
}