package flower.store;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class FlowerBucket {
    private List<flower.store.FlowerPack> flowers;

    public FlowerBucket() {
        this.flowers = new ArrayList<>();
    }
    public FlowerBucket(List<flower.store.FlowerPack> flowers) {
        this.flowers = flowers;
    }

    public void add(flower.store.FlowerPack flowerPack) {
        flowers.add(flowerPack);
    }
    public double getPrice() {
        double price = 0;
        for (flower.store.FlowerPack flowerPack : flowers) {
            price += flowerPack.getPrice();
        }
        return price;
    }
    public List<FlowerType> getFlowerTypes() {
        List<FlowerType> flowerTypes = new ArrayList<>();
        for (flower.store.FlowerPack flowerPack : flowers) {
            flowerTypes.add(flowerPack.getFlower().getFlowerType());
        }
        return flowerTypes;
    }
}
