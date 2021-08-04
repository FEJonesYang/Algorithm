package factory.abstracts.factory;

import factory.Drink;
import factory.Food;
import factory.abstracts.Cola;
import factory.Hamburger;

/**
 * @Author: JonesYong
 * @Data: 2021-08-02
 * @Description:
 */
public class KFCFactory implements FoodFactory {

    @Override
    public Food createFood() {
        return new Hamburger();
    }

    @Override
    public Drink createDrink() {
        return new Cola();
    }
}
