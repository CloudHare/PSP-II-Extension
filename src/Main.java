import structs.FoodItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SushiBarAutomaton automaton = new BasicSushiBarAutomaton();
        automaton.addExtension(new PremiumExtension());
        automaton.addExtension(new DrinkServingExtension());

        List<FoodItem> menu = automaton.getMenu();
        System.out.println("Menu:");
        for(FoodItem item : menu) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
        List<FoodItem> drinkMenu = automaton.getExtension(DrinkServingExtension.class).get().getDrinksMenu();
        System.out.println("Drinks:");
        for(FoodItem item : drinkMenu) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }

        automaton.orderSushi("salmon");
        automaton.getExtension(PremiumExtension.class).get().addExtraToSushi("wasabi");
        automaton.orderSushi("tuna");
        automaton.getExtension(DrinkServingExtension.class).get().orderDrink("sake", 21);
        automaton.getExtension(DrinkServingExtension.class).get().orderDrink("nuka-cola", 12);

        System.out.println("Total: " + automaton.getOrderPrice());
    }
}
