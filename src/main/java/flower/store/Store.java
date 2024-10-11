package flower.store;
import java.util.ArrayList;
import java.util.List;

import lombok.Setter;
@Setter
public class Store {

    private List<FlowerBucket> flowerBuckets;
    public List<FlowerBucket> search(List<FlowerType> flowerTypes) {
        List<FlowerBucket> returnBuckets = new ArrayList<>();
        for (FlowerBucket flowerBucket : flowerBuckets) {
            if (flowerBucket.getFlowerTypes().containsAll(flowerTypes)) {
                returnBuckets.add(flowerBucket);
            }
        }
        return returnBuckets;
    };
}
