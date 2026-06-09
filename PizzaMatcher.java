import java.util.List;
import java.util.ArrayList;

public class PizzaMatcher {

        public static bolean matches(PizzaInfo orderInfo, PizzaInfo pizzaInfo) {
            if(orderInfo.getSize() != pizzaInfo.getSize())
                return false;
            if(orderInfo.getCrust() != pizzaInfo.getCrust())
                return false;
            if(orderInfo.getSauce() != pizzaInfo.getSauce())
                return false;
    
            List<Integer> orderToppings = new ArrayList<>(orderInfo.getToppings);
            List<Integer> pizzaToppings = new ArrayList<>(pizzaInfo.getToppings);
    
            sort(orderToppings);
            sort(pizzaToppings);
    
            return listEqual(orderToppings, pizzaToppings);
        }
    
        private static void sort(List<Integer> lists) {
            for (int i = 1; i < lists.size(); i++) {
    
                int value = lists.get(i);
                int j = i - 1;
    
                while (j >= 0 && lists.get(j) > value) {
                    lists.set(j + 1, lists.get(j));
                    j -= 1;
                }
                lists.set(j + 1, value);
            }
        }
        private static boolean sameList(List<Integer> a, List<Integer> b) {
    
            if (a.size() != b.size())
                return false;
    
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) != b.get(i)) {
                    return false;
            }
        }
            return true;
     }       
}
