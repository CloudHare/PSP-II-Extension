import structs.FoodItem;

import java.util.List;

public interface DrinkExtension extends Extension {
    boolean orderDrink(String drink, int age);

    List<FoodItem> getDrinksMenu();

}
