import structs.FoodItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SushiBarAutomaton automaton = new BasicSushiBarAutomaton();
        automaton.addExtension(new PremiumExtension());

        List<FoodItem> menu = automaton.getMenu();
        System.out.println("Menu:");
        for(FoodItem item : menu) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }

        automaton.orderSushi("salmon");
        automaton.getExtension(PremiumExtension.class).get().addExtraToSushi("wasabi");
        automaton.orderSushi("tuna");

        System.out.println("Total: " + automaton.getOrderPrice());
    }
}
