import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor c = A.class.getConstructor();
        System.out.println(c);
        Constructor[] cs = A.class.getConstructors();
        Constructor[] cs2 = A.class.getDeclaredConstructors();

        //返回A类的第一个public 方法
        Method m = A.class.getMethod("say");
        //执行
        m.invoke(A.class.newInstance(), null);
        //返回A类所有的public 方法
        Method[] ms = A.class.getMethods();
        //返回A类所有的方法，包括private
        Method[] allMs = A.class.getDeclaredMethods();
        //返回A类的public字段
        Field field = A.class.getField("i");
        System.out.println(field.get(A.class.newInstance()));
    }
}

class A{
    public int i = 1;
    public static int j = 2;

    public A(){
        System.out.println("wu can gou zao");
    }
    private A(String s)
    {
        System.out.println("you can gou zao " + s);
    }
    public void say()
    {
        System.out.println("say");
    }
}