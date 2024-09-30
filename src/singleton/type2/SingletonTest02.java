package singleton.type2;

public class SingletonTest02 {
    public static void main(String[] args) {
        System.out.println("懒汉式（线程不安全）：");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}

// 懒汉式（线程不安全），只能在单线程使用，实际开发不建议使用
class Singleton{
    private static Singleton instance;

    private Singleton(){

    }
    // 静态公有方法，当使用该方法时才去创建instance（与饿汉式不同，饿汉式在类加载时即创建）
    // 如果多线程下，一个线程进入if判断语句，还未来得及向下执行，另一个线程也通过判断语句（判断结果均为null），便会导致多个实例产生
    // 可以在方法上加synchronized变为线程安全的方法，但是效率很低（所以不建议这么做），因为实际上instance只需创建一次
    // 而这样写会使得每次要获取该对象的时候都会出现排队现象
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    // 可以加入synchronized同步处理，解决线程安全（但会降低效率）
}
