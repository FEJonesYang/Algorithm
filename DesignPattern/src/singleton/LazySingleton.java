package singleton;

/**
 * @Author: JonesYang
 * @Data: 2021-07-18
 * @Description: 懒汉式
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
