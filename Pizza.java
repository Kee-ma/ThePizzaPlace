import java.util.ArrayList;

public class Pizza {
  private String size;
  private String crust;
  private String sauce;
  private List<String> toppings;

  public class PizzaAssemply(PizzaAssembly Assembly);
    this.size = Assembly.size;
    this.crust = Assembly.crust;
    this.sauce = Assembly.sauce;
    this.toppings = Assembly.toppings;

  public static class PizzaAssembly {
    private List<String> toppings;
  }

  public PizzaAssembly size(String size) {
    this.size = size;
  }

  public PizzaAssembly crust(String crust) {
    this.crust = crust;
  }

  public PizzaAssembly sauce(String sauce) {
    this.sauce = sauce;
  }

  public PizzaAssembly addTopping(String topping) {
    this.topping.add(topping);
    return this;
  }
}
