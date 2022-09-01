package sec.price;

import sec.type.Fruit;
import sec.Package;

import java.util.List;

public class BasePrice implements Price{
    @Override
    public float getTotalPrice(List<Package> packages) throws Exception {
        float total = 0;
        for (Package aPackage : packages) {
            Class<?> aClass = aPackage.getName();
            Fruit fruit = (Fruit)aClass.newInstance();
            float price = fruit.getPrice(aPackage.getUnit());
            total = total + price;
        }
        return total;
    }
}
