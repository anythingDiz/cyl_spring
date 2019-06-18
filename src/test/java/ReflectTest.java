import com.cyl.demo.model.Car;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的demo累
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过类加载器获取Car的类对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.cyl.demo.model.Car");

        //获取类的默认构造器，并且通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor(null);
        Car car= (Car) cons.newInstance();

       //通过反射方法设置属性
        Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
        setBrand.invoke(car, "bmw");

        car.info();

        /**
         * 类加载器 把一个类载入jvm 需要经过以下步築
         *  装载：查找和载入类
         *  连接：解析步可以省却
         *      校验：检查载入的class的正确性
         *      准备：给类的静态变量分配存储空间
         *      解析：对符号引用转为直接引用
         *  初始化：对类的静态变量、静态代码块执行初始化工作
         *
         *  类加载器
         *      RootClassLoader: c语言编写 加载jre核心库
         *      ExtClassLoader： 加载jre扩展目录ext中的jar
         *      AppClassLoader： 负责加载classpath路径下的包
         *
         *  jvm装载类时使用：全盘负责委托机制
         *
         */

        System.out.println(">> current loader: "+ classLoader);
        System.out.println(">> parent loader: " + classLoader.getParent());
        System.out.println(">> grandparent loader: "+ classLoader.getParent().getParent());
    }

    /**
     *通过反射调用私有方法 和 私有变量
     */
    @Test
    public void testPrivateReflect() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.cyl.demo.model.Car");

        Constructor cons = clazz.getDeclaredConstructor(null);
        Car car = (Car) cons.newInstance(null);

        //取消java语言访问检查  以访问私有变量
        Field brand = clazz.getDeclaredField("brand");
        brand.setAccessible(true);
        brand.set(car, "bwm");

        // 回复java语言访问检查
        brand.setAccessible(false);

        car.info();
    }




}
