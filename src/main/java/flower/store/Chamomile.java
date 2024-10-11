package flower.store;

public class Chamomile extends Flower {

    public Chamomile() {
        super();
        this.setFlowerType(FlowerType.CHAMOMILE);
    }
    public Chamomile(FlowerType flowerType, FlowerColor color, double sepalLength, double price) {
        super(FlowerType.CHAMOMILE, color, sepalLength, price);
    }
    
}
