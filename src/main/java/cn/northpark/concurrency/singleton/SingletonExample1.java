package cn.northpark.concurrency.singleton;

import cn.northpark.concurrency.annotaion.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * <pre>分析：
       在多线程环境下，当两个线程同时访问这个方法，同时制定到instance==null的判断都判断为null，
       接下来同时执行new操作。这样类的构造函数被执行了两次。
       一旦构造函数中涉及到某些资源的处理，
       那么就会发生错误。所以说最简式是线程不安全的
   </pre>    
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有构造函数
    private SingletonExample1() {

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态的工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
