package factory;


/**
 * @Author: JonesYong
 * @Data: 2021-08-01
 * @Description:
 */
public class Hamburger implements Food {


    @Override
    public void createFood() {
        System.out.println("Hamburger was created.");
    }
}
