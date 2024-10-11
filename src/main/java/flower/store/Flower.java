package flower.store;

import lombok.Getter;
import lombok.Setter;
@Setter
public class Flower {
    public static final double DEFAULT_SEPALLENGHT = 5;
    public static final double DEFAULT_PRICE = 10;

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
        this.sepalLength = DEFAULT_SEPALLENGHT;
        this.price = DEFAULT_PRICE;
    }

    public Flower(FlowerType flowerType,
     FlowerColor color, double sepalLength, double price) {
        this.flowerType = flowerType;
        this.color = color;
        this.sepalLength = sepalLength;
        this.price = price;
    }
    public String getColor() {
        return color.toString();
    }

    public void setColor(FlowerColor newColor) {
        this.color = newColor;
    }
}
