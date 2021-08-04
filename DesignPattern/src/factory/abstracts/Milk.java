package factory.abstracts;

import factory.Drink;

/**
 * @Author: JonesYong
 * @Data: 2021-08-02
 * @Description:
 */
public class Milk implements Drink {
    @Override
    public void createDrink() {
        System.out.println("Milk was created.");
    }
}
