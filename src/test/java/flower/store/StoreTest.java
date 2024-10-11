package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.ArrayList;

public class StoreTest {
    private Store store;
    private FlowerBucket bucket1;
    private FlowerBucket bucket2;

    @BeforeEach
    public void init() {
        store = new Store();
        Flower rose = new Flower(FlowerType.ROSE, FlowerColor.RED, 7.5, 15);
        Flower tulip = new Flower(FlowerType.TULIP, FlowerColor.BLUE, 6.0, 10);

        FlowerPack rosePack = new FlowerPack(rose, 10);
        FlowerPack tulipPack = new FlowerPack(tulip, 5);

        bucket1 = new FlowerBucket();
        bucket1.add(rosePack);

        bucket2 = new FlowerBucket();
        bucket2.add(tulipPack);

        List<FlowerBucket> flowerBuckets = new ArrayList<>();
        flowerBuckets.add(bucket1);
        flowerBuckets.add(bucket2);
        store.setFlowerBuckets(flowerBuckets);
    }

    @Test
    public void testSearchSingleFlowerType() {
        List<FlowerType> searchTypes = new ArrayList<>();
        searchTypes.add(FlowerType.ROSE);

        List<FlowerBucket> result = store.search(searchTypes);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(bucket1));
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
