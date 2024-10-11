package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.ArrayList;

public class StoreTest {
    private static final double SEPAL_LENGTH_ONE = 7.5;
    private static final double SEPALLENGTHTWO = 6.0;
    private static final double PRISEONE = 15;
    private static final double PRISTWO = 10;
    private static final int FIRST_QUANTITY = 10;
    private static final int SECOND_QUANTITY = 5;
    private Store store;
    private FlowerBucket bucketOne;
    private FlowerBucket bucketTwo;
    @BeforeEach
    public void init() {
        store = new Store();
        Flower rose = new Flower(FlowerType.ROSE,
         FlowerColor.RED, SEPAL_LENGTH_ONE, PRISEONE);
        Flower tulip = new Flower(FlowerType.TULIP,
         FlowerColor.BLUE, SEPALLENGTHTWO, PRISTWO);

        FlowerPack rosePack = new FlowerPack(rose, FIRST_QUANTITY);
        FlowerPack tulipPack = new FlowerPack(tulip, SECOND_QUANTITY);

        bucketOne = new FlowerBucket();
        bucketOne.add(rosePack);

        bucketTwo = new FlowerBucket();
        bucketTwo.add(tulipPack);

        List<FlowerBucket> flowerBuckets = new ArrayList<>();
        flowerBuckets.add(bucketOne);
        flowerBuckets.add(bucketTwo);
        store.setFlowerBuckets(flowerBuckets);
    }

    @Test
    public void testSearchSingleFlowerType() {
        List<FlowerType> searchTypes = new ArrayList<>();
        searchTypes.add(FlowerType.ROSE);

        List<FlowerBucket> result = store.search(searchTypes);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucketOne));
    }

    @Test
    public void testSearchMultipleFlowerTypes() {
        List<FlowerType> searchTypes = new ArrayList<>();
        searchTypes.add(FlowerType.ROSE);
        searchTypes.add(FlowerType.TULIP);

        List<FlowerBucket> result = store.search(searchTypes);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchNoMatch() {
        List<FlowerType> searchTypes = new ArrayList<>();
        searchTypes.add(FlowerType.CHAMOMILE);

        List<FlowerBucket> result = store.search(searchTypes);
        Assertions.assertTrue(result.isEmpty());
    }
}
