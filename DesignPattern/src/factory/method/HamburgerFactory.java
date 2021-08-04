package factory.method;

import factory.Food;
import factory.Hamburger;

/**
 * @Author: JonesYong
 * @Data: 2021-08-02
 * @Description:
 */
public class HamburgerFactory implements FoodFactory{
    @Override
    public Food createFood() {
        return new Hamburger();
    }
}
