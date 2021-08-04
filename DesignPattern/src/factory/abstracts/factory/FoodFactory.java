package factory.abstracts.factory;

import factory.Drink;
import factory.Food;

/**
 * @Author: JonesYong
 * @Data: 2021-08-02
 * @Description:
 */
public interface FoodFactory {
    Food createFood();

    Drink createDrink();
}
