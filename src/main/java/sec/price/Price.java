package sec.price;

import java.util.List;
import sec.Package;

public interface Price {
    float getTotalPrice(List<Package> packages) throws Exception;
}
