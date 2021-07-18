package singleton;

import java.io.Serializable;

/**
 * @Author: JonesYong
 * @Data: 2021-07-18
 * @Description: double check
 */
public class DoubleCheckSingleton implements Serializable {
    private static volatile DoubleCheckSingleton instance; // ----> 注释1

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            // ----> 注释2
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) { // ----> 注释3
                    // ----> 注释4 复杂操作
                    instance = new DoubleCheckSingleton();
                    // ----> 注释5 复杂操作
                }
            }
        }
        return instance;
    }
}
