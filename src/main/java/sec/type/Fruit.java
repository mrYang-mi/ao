package sec.type;

public abstract class Fruit {
    // 单价
    abstract float getUnitPrice();

    float discount() {
        return 1;
    }

    public float getPrice(Integer unit) {
        return unit * getUnitPrice() * discount();
    }
}
