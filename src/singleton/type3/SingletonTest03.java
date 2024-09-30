package singleton.type3;

public class SingletonTest03 {
    public static void main(String[] args) {
        System.out.println("懒汉式（线程安全）：");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}

// 懒汉式（线程安全）
class Singleton{
    private static volatile Singleton instance; // volatile关键字

    private Singleton(){

    }
    // 静态公有方法，当使用方法时才去创建instance（与饿汉式不同，饿汉式在类加载时即创建）
    // 该方法推荐使用，效率较高
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){ // 双重检查，防止多个线程同时通过上一层if后，多次调用new方法，从而创建多个实例
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
