package flower.store;

import java.util.List;

public class FlowerBucket {
    private List<flower.store.FlowerPack> flowers;
    private double price;

    public FlowerBucket() {
        flowers = List.of();
        price = 0;
    }
    public FlowerBucket( List<flower.store.FlowerPack> flowers) {
        this.flowers = flowers;
        price = this.getPrice();
    }

    public void add(flower.store.FlowerPack flowerPack) {
        flowers.add(flowerPack);
        price = this.getPrice();
    }
    public double getPrice() {
        for (flower.store.FlowerPack flowerPack : flowers) {
            price += flowerPack.getPrice();
        }
        return price;
    }
}
