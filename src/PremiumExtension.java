import structs.FoodItem;
import structs.Sushi;

import java.util.ArrayList;
import java.util.List;

public class PremiumExtension implements SushiExtension {

    private BasicSushiBarAutomaton automaton;
    private List<FoodItem> menu = new ArrayList<>();

    public PremiumExtension() {
        menu.add(new FoodItem("tuna", 4.25));
        menu.add(new FoodItem("wasabi", 0.4));
    }

    @Override
    public boolean addExtraToSushi(String extra) {
        List<FoodItem> fullMenu = automaton.getMenu();
        for (FoodItem item: fullMenu) {
            if(item.getName().equals(extra)){
                automaton.addExtraToSushi(item);
                return true;
            }
        }

        return false;
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
