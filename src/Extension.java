import structs.FoodItem;

import java.util.List;

public interface Extension {

    List<FoodItem> getMenu();

    void setSushiBarAutomaton(SushiBarAutomaton automaton);
}
