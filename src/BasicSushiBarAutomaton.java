import structs.FoodItem;
import structs.Sushi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicSushiBarAutomaton implements SushiBarAutomaton{

    private List<Sushi> orders = new ArrayList<>();
    private List<FoodItem> menu = new ArrayList<>();
    private List<Extension> extensions = new ArrayList<>();

    public BasicSushiBarAutomaton(){
        menu.add(new FoodItem("salmon", 3.10));
        menu.add(new FoodItem("eel", 5.20));
    }

    @Override
    public boolean orderSushi(String fish) {
        List<FoodItem> fullMenu = getMenu();
        for (FoodItem item: fullMenu) {
            if(item.getName().equals(fish)){
                orders.add(new Sushi(item));
                return true;
            }
        }

        return false;
    }

    @Override
    public double getOrderPrice() {
        double totalPrice = 0;

        for (Sushi item: orders) {
            totalPrice += item.getFish().getPrice();
            for (FoodItem extra: item.getExtras()) {
                totalPrice += extra.getPrice();
            }
        }

        return totalPrice;
    }

    @Override
    public List<FoodItem> getMenu() {
        List<FoodItem> menuClone = new ArrayList<>();

        for (FoodItem item: menu) {
            menuClone.add(item.clone());
        }

        List<FoodItem> extentionMenu;
        for (Extension extension: extensions) {
            extentionMenu = extension.getMenu();
            for (FoodItem item: extentionMenu) {
                menuClone.add(item.clone());
            }
        }

        return menuClone;
    }

    protected void addExtraToSushi(FoodItem extra) {
        orders.get(orders.size()-1).addExtra(extra);
    }

    @Override
    public void addExtension(Extension  extension) {
        this.extensions.add(extension);
        extension.setSushiBarAutomaton(this);
    }


    @Override
    public <T extends Extension> Optional<T> getExtension(Class<T> extensionClass) {
        return extensions.stream()
                .filter(extension -> extensionClass.isInstance(extension))
                .map(extension -> (T) extension)
                .findFirst();
    }
}
