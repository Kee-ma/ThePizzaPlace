import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameManager {

    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";
    public static final String RED    = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    private Scanner input;

    private List<Order> orders;

    private Inventory inventory;
    private IngredientTruck truck;
    private Oven oven;
    private int pizzasMade;

    private PizzaInfo savedPizza;

    private int strikes;

    private Random random;

    public GameManager() {

        input = new Scanner(System.in);

        orders = new ArrayList<>();
        inventory = new Inventory();
        truck = new IngredientTruck();
        oven = new Oven();

        random = new Random();
    }

    public void start() {

        printRules();

        while (true) {

            truck.update();

            if (oven.hasBurnedPizza()) {
                System.out.println(RED + "\nA pizza burned! THE PLACE IS ON FIRE!" + "\n" +
                        "YOU'RE FIRED. GAME OVER" + RESET);
                System.out.println("Pizzas made:" + pizzasMade);
                return;
            }

            System.out.println("\n[C] Cashier");
            System.out.println("[K] Kitchen");
            System.out.println("[S] Stock Room");
            System.out.println("[O] Oven");

            String choice = input.nextLine().toUpperCase();

            if (choice.equals("C")) {
                cashierRoom();
            }
            else if (choice.equals("K")) {
                kitchenRoom();
            }
            else if (choice.equals("S")) {
                stockRoom();
            }
            else if (choice.equals("O")) {
                ovenRoom();
            }
        }
    }

    private void printRules() {

        System.out.println("***** Welcome to the PIZZA PLACE!!! *****");
        System.out.println("Take orders. (press c)");
        System.out.println("Build pizzas.(press k to start making orders. Match the components to their index)");
        System.out.println("Restock ingredients. (frequently visit the stock room! The truck only stays for 10s!)");
        System.out.println("3 incorrect pizzas = game over!");
        System.out.println("Pizza ready at 60 seconds.");
        System.out.println("Pizza burns at 70 seconds = game over!");
        System.out.println();
        System.out.println("Press C to begin.");
    }

    private void cashierRoom() {

        PizzaInfo info = randomPizza();

        Order order = new Order(info);

        orders.add(order);

        System.out.println("___________" + "\nNew Order Added");
        System.out.println(order);
    }

    private void kitchenRoom() {

        if (orders.size() == 0) {

            System.out.println(RED + "No orders." + RESET);
            return;
        }

        System.out.println("\nOrders:");

        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.print("___________" + "\nChoose order id: ");

        int orderId = getInt();

        Order selected = null;

        for (Order order : orders) {
            if (order.getId() == orderId) {
                selected = order;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Order not found.");
            return;
        }

        PizzaInfo builtPizza = buildPizza(selected);

        if (builtPizza == null) {
            return;
        }

        Pizza pizza = new Pizza(builtPizza);

        //Incorrect pizza count
        if (!PizzaMatcher.matches(selected.getInfo(), builtPizza)) {

            strikes++;

            System.out.println(RED + "Incorrect pizza! Strike " + strikes + RESET);

            if (strikes >= 3) {
                System.out.println(RED + "Too many incorrect pizzas, too many wasted ingredients! GAME OVER" + RESET);
                System.out.println("Pizzas made:" + pizzasMade);
                System.exit(0);
            }
            return;
        }

        oven.addPizza(pizza);
        orders.remove(selected);

        pizzasMade++;

        System.out.println(YELLOW + "\nPizza added to oven\n" + RESET);
        System.out.println(GREEN + "Order #" + selected.getId() + " completed!!!" + RESET);
    }

    private PizzaInfo buildPizza(Order order) {

        System.out.println("\nBuild that order!!!:");
        System.out.println(order.getInfo());

        System.out.println("Size:");
        System.out.println("1 Small");
        System.out.println("2 Medium");
        System.out.println("3 Large");

        int size = getInt();

        System.out.println("\nPick Crust:");
        System.out.println("1 Thin");
        System.out.println("2 Normal");
        System.out.println("3 Thick");

        int crust = getInt();

        System.out.println("\nPick Sauce:");
        System.out.println("1 Tomato");
        System.out.println("2 BBQ");
        System.out.println("3 Alfredo");

        int sauce = getInt();

        List<Integer> toppings = new ArrayList<>();

        while(true) {

            inventory.printInventory();

            System.out.println("Add topping");
            System.out.println("1 Cheese");
            System.out.println("2 Pepperoni");
            System.out.println("3 Mushroom");
            System.out.println("4 Pineapple");
            System.out.println("5 Onion");
            System.out.println("0 Finish");

            int topping = getInt();

            if (topping == 0) {
                break;
            }

            if (!inventory.useIngredient(topping)) {
                System.out.println(RED + "Out of stock!" + RESET);
            }
            else {
                toppings.add(topping);
            }
        }

        return new PizzaInfo(size, crust, sauce, toppings);
    }

    private void stockRoom() {

        if (truck.isPresent()) {

            System.out.println(BLUE + "Truck is here. Press enter to unload." + RESET);

            input.nextLine();

            truck.unload(inventory);
        }
        else {
            System.out.println(RED + "No truck here." + RESET);
        }
    }

    private void ovenRoom() {

        oven.showPizzas();

        if (oven.getPizzas().size() == 0) {
            return;
        }

        System.out.println("Choose pizza number to remove (0 = cancel)");

        int choice = getInt();

        if (choice == 0) {
            return;
        }

        Pizza pizza = oven.removePizza(choice - 1);

        if (pizza == null) {
            return;
        }

        if (!pizza.isReady()) {

            System.out.println(YELLOW + "Pizza is not ready yet." + RESET);

            oven.addPizza(pizza);
            return;
        }

        System.out.println(GREEN + "Pizza removed successfully. It has been delivered to its customer" + RESET);
    }

    //random custom order
    private PizzaInfo randomPizza() {

        int size = random.nextInt(3) + 1;
        int crust = random.nextInt(3) + 1;
        int sauce = random.nextInt(3) + 1;

        int count = random.nextInt(4) + 1;

        List<Integer> toppings = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            toppings.add(random.nextInt(5) + 1);
        }

        return new PizzaInfo(size, crust, sauce, toppings);
    }

    // AI
    private int getInt() {

        try {

            return Integer.parseInt(input.nextLine());
        }
        catch (Exception e) {

            System.out.println("Enter a number.");

            return getInt();
        }
    }
}
