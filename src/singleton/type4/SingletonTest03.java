package singleton.type4;

public class SingletonTest03 {
    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式：");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}

// 静态内部类完成，推荐使用
class Singleton{
    private static volatile Singleton instance; // volatile关键字
    // 仍然需要私有化构造器
    private Singleton(){

    }
    // 静态内部类含有静态属性（JVM底层的类装载是线程安全的）
    // 类的静态属性只有第一次加载类的时候初始化，Singleton类装载时该类不会装载
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    // 公有静态方法直接返回静态属性
    public static synchronized Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
