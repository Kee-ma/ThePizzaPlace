import java.util.ArrayList;

public class PizzaInfo {
  private final int size;
  private final int crust;
  private final int sauce;
  private List<String> toppings;

  public class PizzaInfo(int size, int crust, int  sauce, List<Integer> toppings) {
    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.toppings = new ArrayList<>(toppings);
  }
  
  public int getSize {
    return size;
  }
  public int getCrust {
    return crust;
  }
  public int getSauce {
    return sauce;
  }
  
  public List<Integer> getToppings() {
    return new ArrayList<>(toppings);
  }
}
