package leetCode.design;

/**
 * 单列模式
 * Created by ZXL on 2019/9/19.
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
