package singleton.type1;

public class SingletonTest01 {
    public static void main(String[] args) {
        // 测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // 无论调用多少次，返回都是同一个对象
    }
}

// 静态常量饿汉式
// 优点：写法简单，类装载的时候完成实例化，避免线程同步问题
// 缺点：类装载的时候就完成实例化，如果从始至终没有使用过该实例，会造成内存浪费
// 结论：可以用，可能导致内存浪费
class Singleton{
    // 构造器私有化，使得外部无法创建对象
    private Singleton(){
        
    }
    // 本类内部创建对象实例（亦可以静态代码块形式初始化，优缺点类似）
    private final static Singleton instance = new Singleton();
    // 提供公有静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
