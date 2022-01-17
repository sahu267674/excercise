package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> orderedFurniture= new HashMap<Furniture, Integer>();


    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        orderedFurniture.put(Furniture.CHAIR,0);
        orderedFurniture.put(Furniture.COUCH,0);
        orderedFurniture.put(Furniture.TABLE,0);
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        orderedFurniture.put(type,orderedFurniture.get(type)+furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return orderedFurniture;
    }

    public float getTotalOrderCost() {
        if(!orderedFurniture.isEmpty()) {
            return orderedFurniture.entrySet().stream()
                    .map(f -> f.getKey().cost() * f.getValue())
                    .collect(Collectors.toList())
                    .stream()
                    .reduce(Float::sum)
                    .get();
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        return orderedFurniture.get(type);
    }

    public float getTypeCost(Furniture type) {
        return orderedFurniture.get(type)*type.cost();
    }

    public int getTotalOrderQuantity() {
        return orderedFurniture.values().stream().mapToInt(Integer::intValue).sum();
    }
}