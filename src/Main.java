import structs.FoodItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SushiBarAutomaton automaton = new BasicSushiBarAutomaton();

        List<FoodItem> menu = automaton.getMenu();
        System.out.println("Menu:");
        for(FoodItem item : menu) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }

        automaton.orderSushi("salmon");
        automaton.orderSushi("salmon");

        System.out.println("Total: " + automaton.getOrderPrice());
    }
}
