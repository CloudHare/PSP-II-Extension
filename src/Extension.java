import structs.FoodItem;

import java.util.List;

public interface Extension {
    void setSushiBarAutomaton(SushiBarAutomaton automaton);

    List<FoodItem> getMenu();

    double getOrderPrice();
}
