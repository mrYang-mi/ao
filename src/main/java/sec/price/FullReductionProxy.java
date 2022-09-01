package sec.price;

import java.util.List;
import sec.Package;


public class FullReductionProxy implements Price {
    private Price basePrice;

    public FullReductionProxy(Price basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public float getTotalPrice(List<Package> packages) throws Exception {
        float totalPrice = basePrice.getTotalPrice(packages);
        int v = (int)totalPrice / 100;
        return totalPrice - v * 10;
    }
}
