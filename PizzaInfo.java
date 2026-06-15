import java.util.ArrayList;

public class PizzaInfo {
  private int size;
  private int crust;
  private int sauce;
  private List<Integer> toppings;

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

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PizzaInfo)obj;
    return PizzaMatcher.matches(this, other);
    }
  @Override 
    public String toString() {

    return "Size: " + size + ", Crust: " + crust + ", Sauce: " + sauce + ", Toppings: " + toppings;
  }
}
