import java.util.ArrayList;
import java.util.List;

public class PizzaInfo {

    private int size;
    private int crust;
    private int sauce;
    private List<Integer> toppings;

    public PizzaInfo(int size, int crust, int sauce, List<Integer> toppings) {

        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = new ArrayList<>(toppings);
    }

    public int getSize() {
        return size;
    }
    public int getCrust() {
        return crust;
    }
    public int getSauce() {
        return sauce;
    }
    public List<Integer> getToppings() {
        return new ArrayList<>(toppings);
    }

    @Override
    public String toString() {

        return "Size: " + sizeName(size)
                + "\nCrust: " + crustName(crust)
                + "\nSauce: " + sauceName(sauce)
                + "\nToppings: " + toppingsText();
    }

    // ______To help it say the name of the ingredient, NOT as their index when printing________

    private String sizeName(int s) {

        if (s == 1)
            return "Small";
        if (s == 2)
            return "Medium";
        return "Large";
    }

    private String crustName(int c) {

        if (c == 1)
            return "Thin";
        if (c == 2)
            return "Normal";
        return "Thick";
    }

    private String sauceName(int s) {

        if (s == 1)
            return "Tomato";
        if (s == 2)
            return "BBQ";
        return "Alfredo";
    }

    //Converts the full list of index version of ingredients into a readable list
    private String toppingsText() {

        if (toppings.size() == 0) {
            return "(none)";
        }

        String text = "";

        for (int i = 0; i < toppings.size(); i++) {

            text += toppingName(toppings.get(i));

            if (i < toppings.size() - 1) {
                text += ", ";
            }
        }

        return text;
    }

    //Assigns each ingredient in the list a name
    private String toppingName(int t) {

        if (t == 1)
            return "Cheese";
        if (t == 2)
            return "Pepperoni";
        if (t == 3)
            return "Mushroom";
        if (t == 4)
            return "Pineapple";

        return "Onion";
    }

    //___________End of conversions for printing_____________________


    //Compares the WHOLE pizza- method that compares just the ingredients can be found in the
    //PizzaMatcher class
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof PizzaInfo)) {
            return false;
        }

        PizzaInfo other = (PizzaInfo) obj;

        return PizzaMatcher.matches(this, other);
    }
}
