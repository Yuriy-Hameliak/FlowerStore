package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    private void testFlowerPrice(Flower flower) {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testPriceWithRose() {
        testFlowerPrice(new Rose());
    }

    @Test
    public void testPriceWithTulip() {
        testFlowerPrice(new Tulip());
    }

    @Test
    public void testPriceWithChamomile() {
        testFlowerPrice(new Chamomile());
    }

    @Test
    public void testMultipleFlowerTypesInBucket() {
        int rosePrice = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int roseQuantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower rose = new Rose();
        rose.setPrice(rosePrice);
        FlowerPack rosePack = new FlowerPack(rose, roseQuantity);
        flowerBucket.add(rosePack);

        int tulipPrice = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int tulipQuantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower tulip = new Tulip();
        tulip.setPrice(tulipPrice);
        FlowerPack tulipPack = new FlowerPack(tulip, tulipQuantity);
        flowerBucket.add(tulipPack);

        int chamomilePrice = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int chamomileQuantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower chamomile = new Chamomile();
        chamomile.setPrice(chamomilePrice);
        FlowerPack chamomilePack = new FlowerPack(chamomile, chamomileQuantity);
        flowerBucket.add(chamomilePack);

        double expectedPrice = rosePrice * roseQuantity
                            + tulipPrice * tulipQuantity
                            + chamomilePrice * chamomileQuantity;

        Assertions.assertEquals(expectedPrice, flowerBucket.getPrice());
    }

    @Test
    public void testEmptyBucketPrice() {
        Assertions.assertEquals(0, flowerBucket.getPrice());
    }
}
