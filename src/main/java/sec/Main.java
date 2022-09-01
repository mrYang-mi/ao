package sec;

import sec.price.BasePrice;
import sec.price.FullReductionProxy;
import sec.Package;
import java.util.ArrayList;
import java.util.List;
import static sec.constants.Constant.*;
import static sec.constants.Constant.STRAWBERRY;

public class Main {
    public static void main(String[] args) throws Exception {
//        1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
//        现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
//        请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        List<Package> packages = new ArrayList<>();
        packages.add(new Package(APPLE, 2));
        packages.add(new Package(STRAWBERRY, 2));
        BasePrice basePrice = new BasePrice();
        float totalPrice = basePrice.getTotalPrice(packages);
        System.out.println(totalPrice); // 42.0

//        2、超市增加了一种水果芒果，其定价为 20 元/斤。
//        现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
//        请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        packages.add(new Package(MANGO, 2));
        float totalPrice2 = basePrice.getTotalPrice(packages);
        System.out.println(totalPrice2);

//        3、超市做促销活动，草莓限时打 8 折。
//        现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
//        请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        List<Package> packages2 = new ArrayList<>();
        packages2.add(new Package(APPLE, 2));
        packages2.add(new Package(STRAWBERRY_DISCOUNT, 20));
        packages2.add(new Package(MANGO, 2));
        float totalPrice3 = basePrice.getTotalPrice(packages2);
        System.out.println(totalPrice3);

//        4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
//        现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
//        请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        FullReductionProxy fullReductionProxy = new FullReductionProxy(basePrice);
        float totalPrice4 = fullReductionProxy.getTotalPrice(packages2);
        System.out.println(totalPrice4);
    }
}
