package flower.store;

import lombok.Getter;
import lombok.Setter;
@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;
    public Flower() {
        this.flowerType = FlowerType.CHAMOMILE;
        this.color = FlowerColor.RED;
        this.sepalLength = 5;
        this.price = 10;
    }

    public Flower(FlowerType flowerType, FlowerColor color, double sepalLength, double price) {
        this.flowerType = flowerType;
        this.color = color;
        this.sepalLength = sepalLength;
        this.price = price;
    }
    public String getColor() {
        return color.toString();
    }

    public void setColor(FlowerColor color) {
        this.color = color;
    }
}
