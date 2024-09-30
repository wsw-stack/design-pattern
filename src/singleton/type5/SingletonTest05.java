package singleton.type5;

public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
    }
}

// 枚举实现单例模式，推荐使用（JDK底层机制使得枚举类可以避免多线程同步问题）
enum Singleton{
    INSTANCE; // 属性
    public void sayOK(){
        System.out.println("ok~");
    }
}
