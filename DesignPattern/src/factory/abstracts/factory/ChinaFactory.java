package factory.abstracts.factory;

import factory.Drink;
import factory.Food;
import factory.abstracts.Milk;
import factory.Noodle;

/**
 * @Author: JonesYong
 * @Data: 2021-08-02
 * @Description:
 */
public class ChinaFactory implements FoodFactory {

    @Override
    public Food createFood() {
        return new Noodle();
    }

    @Override
    public Drink createDrink() {
        return new Milk();
    }
}
