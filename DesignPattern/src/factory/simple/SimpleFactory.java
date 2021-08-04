package factory.simple;

import factory.Food;
import factory.Hamburger;
import factory.Noodle;

/**
 * @Author: JonesYong
 * @Data: 2021-08-01
 * @Description:
 */
public class SimpleFactory {
    public static Food getFoodInstance(String type) {
        Food food = null;
        switch (type) {
            case "Noodle":
                food = new Noodle();
                break;
            case "Hamburger":
                food = new Hamburger();
                break;
        }
        return food;
    }
}
