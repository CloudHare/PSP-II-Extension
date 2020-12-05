import structs.FoodItem;
import structs.Sushi;

import java.util.ArrayList;
import java.util.List;

public class DrinkServingExtension implements DrinkExtension {

    private BasicSushiBarAutomaton automaton;
    private List<FoodItem> menu = new ArrayList<>();
    private List<FoodItem> drinkMenu = new ArrayList<>();

    public DrinkServingExtension() {
        drinkMenu.add(new FoodItem("sake", 3.50));
        drinkMenu.add(new FoodItem("nuka-cola", 2.80));
        menu.add(new FoodItem("soy sauce", 0.85));
    }

    @Override
    public boolean orderDrink(String drink, int age) {
        if(!eligibleAge(drink, age)) return false;
        for (FoodItem item: drinkMenu) {
            if(item.getName().equals(drink)){
                automaton.addExtraToSushi(item);
                return true;
            }
        }

        return false;
    }

    private boolean eligibleAge(String drink, int age) {
        switch (drink) {
            case "sake": return age >= 20;
            case "duff beer": return age >= 20;
            default: return true;
        }
    }

    @Override
    public List<FoodItem> getDrinksMenu() {
        List<FoodItem> menuClone = new ArrayList<>();

        for (FoodItem item: drinkMenu) {
            menuClone.add(item.clone());
        }
        return menuClone;
    }

    @Override
    public List<FoodItem> getMenu() {
        List<FoodItem> menuClone = new ArrayList<>();

        for (FoodItem item: menu) {
            menuClone.add(item.clone());
        }
        return menuClone;
    }

    @Override
    public void setSushiBarAutomaton(SushiBarAutomaton automaton) {
        if(automaton.getClass().equals(BasicSushiBarAutomaton.class)) {
            this.automaton = (BasicSushiBarAutomaton) automaton;
        }
    }
}
