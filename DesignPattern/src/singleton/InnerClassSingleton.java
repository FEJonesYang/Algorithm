package singleton;

/**
 * @Author: JonesYong
 * @Data: 2021-07-18
 * @Description: 静态类部类实现单例模式
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.INSTANCE;
    }

    private static final class InnerClassHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

}
