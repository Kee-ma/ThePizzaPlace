import java.util.ArrayList;
import java.util.List;

public class PizzaMatcher {

    public static boolean matches(PizzaInfo orderInfo, PizzaInfo pizzaInfo) {

        if (orderInfo.getSize() != pizzaInfo.getSize())
            return false;

        if (orderInfo.getCrust() != pizzaInfo.getCrust())
            return false;

        if (orderInfo.getSauce() != pizzaInfo.getSauce())
            return false;

        List<Integer> orderToppings = new ArrayList<>(orderInfo.getToppings());
        List<Integer> pizzaToppings = new ArrayList<>(pizzaInfo.getToppings());

        sort(orderToppings);
        sort(pizzaToppings);

        return sameList(orderToppings, pizzaToppings);
    }

    //Insertion sort so that ingredient order in our pizza and the customer's pizza match
    //when we are comparing them
    private static void sort(List<Integer> list) {

        for (int i = 1; i < list.size(); i++) {

            int value = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > value) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, value);
        }
    }

    //Compares just the ingredients- the method that compares the entire pizza can be found in the
    //PizzaInfo class
    private static boolean sameList(List<Integer> first, List<Integer> second) {

        if (first.size() != second.size())
            return false;

        for (int i = 0; i < first.size(); i++) {

            if (!first.get(i).equals(second.get(i)))
                return false;
        }

        return true;
    }

}
