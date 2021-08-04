package factory;


/**
 * @Author: JonesYong
 * @Data: 2021-08-01
 * @Description:
 */
public class Noodle implements Food {

    @Override
    public void createFood() {
        System.out.println("noodle was created.");
    }
}
