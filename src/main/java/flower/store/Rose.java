package flower.store;

public class Rose extends Flower {
    public Rose() {
        super();
        this.setFlowerType(FlowerType.ROSE);
    }
    public Rose(FlowerType flowerType, FlowerColor color, double sepalLength, double price) {
        super(FlowerType.ROSE, color, sepalLength, price);
    }
    
}
