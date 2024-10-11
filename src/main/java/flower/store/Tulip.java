package flower.store;

public class Tulip extends Flower {
    public Tulip() {
        super();
        this.setFlowerType(FlowerType.TULIP);
    }
    public Tulip(FlowerType flowerType,
     FlowerColor color, double sepalLength, double price) {
        super(FlowerType.TULIP, color, sepalLength, price);
    }
    
}
