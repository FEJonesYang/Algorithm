package factory.method;

import factory.Food;
import factory.Noodle;

/**
 * @Author: JonesYong
 * @Data: 2021-08-02
 * @Description:
 */
public class NoodleFactory implements FoodFactory {
    @Override
    public Food createFood() {
        return new Noodle();
    }
}
