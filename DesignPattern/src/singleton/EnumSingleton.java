package singleton;

/**
 * @Author: JonesYong
 * @Data: 2021-07-18
 * @Description: 枚举单例
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
