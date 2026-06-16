import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private Map<Integer, Integer> stock;

    public Inventory() {

        stock = new HashMap<>();

        stock.put(IngredientCode.CHEESE, 10);
        stock.put(IngredientCode.PEPPERONI, 10);
        stock.put(IngredientCode.MUSHROOM, 10);
        stock.put(IngredientCode.PINEAPPLE, 10);
        stock.put(IngredientCode.ONION, 10);
    }

    public boolean hasIngredient(int ingredient) {
        return stock.getOrDefault(ingredient, 0) > 0;
        //the "OrDefault" aspect was recommended by ai so that entering a number higher than
        //5 when picking ingredients doesn't crash the code, instead saying it is "out of stock"
    }

    public boolean useIngredient(int ingredient) {

        if (!hasIngredient(ingredient)) {
            return false;
        }

        stock.put(ingredient, stock.get(ingredient) - 1);
        return true;
    }

    public void restock() {

        for (Integer ingredient : stock.keySet()) {
            stock.put(ingredient, stock.get(ingredient) + 10);
        }

        System.out.println(GREEN + "Truck unloaded. Inventory restocked." + RESET);
    }

    public void printInventory() {

        System.out.println(BLUE + "\nInventory" + "\n" +
                "___________________________" + "\n" +
                "Cheese: " + stock.get(IngredientCode.CHEESE) + "\n" +
                "Pepperoni: " + stock.get(IngredientCode.PEPPERONI) + "\n" +
                "Mushroom: " + stock.get(IngredientCode.MUSHROOM) + "\n" +
                "Pineapple: " + stock.get(IngredientCode.PINEAPPLE) + "\n" +
                "Onion: " + stock.get(IngredientCode.ONION) + RESET);
    }
}
