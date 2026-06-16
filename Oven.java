import java.util.ArrayList;
import java.util.List;

public class Oven {

    private List<Pizza> pizzas;

    public Oven() {
        pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {

        pizza.putInOven();
        pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void showPizzas() {

        if (pizzas.size() == 0) {
            System.out.println("Oven is empty.");
            return;
        }

        for (int i = 0; i < pizzas.size(); i++) {

            Pizza pizza = pizzas.get(i);

            System.out.println((i + 1) + ". Time in oven: " + pizza.getTimeInOven() + " seconds");
        }
    }

    public Pizza removePizza(int index) {

        if (index < 0 || index >= pizzas.size()) {
            return null;
        }

        return pizzas.remove(index);
    }

    public boolean hasBurnedPizza() {

        for (Pizza pizza : pizzas) {
            if (pizza.isBurned()) {
                return true;
            }
        }

        return false;
    }
}
