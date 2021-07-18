package singleton;

/**
 * @Author: JonesYang
 * @Data: 2021-07-18
 * @Description: 饿汉式的单例模式
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
