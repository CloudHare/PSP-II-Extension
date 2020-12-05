import structs.FoodItem;

import java.util.List;
import java.util.Optional;

public interface SushiBarAutomaton {
    boolean orderSushi(String fish);

    double getOrderPrice();

    List<FoodItem> getMenu();

    void addExtension(Extension extension);

    <T extends Extension> Optional<T> getExtension(Class<T> extensionClass);
}
