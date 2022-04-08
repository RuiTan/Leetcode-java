package vip.trgg;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class ProxyTest {
    @AllArgsConstructor
    static class TestClass{
        int number;
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestClass test = (TestClass) o;
            return number == test.number && Objects.equals(name, test.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }

    @Test
    public void CHMTest(){
        Map<TestClass, Integer> map = new HashMap<>();
        TestClass testClass = new TestClass(1, "a");
        map.put(testClass, 1);
        map.put(new TestClass(1, "b"), 1);
        System.out.println(map.get(testClass));
        testClass.number = 2;
        System.out.println(map.get(testClass));
        for (int i = 0; i < 6; i++) {
            map.put(new TestClass(1, " " + i), 1);
        }
        System.out.println(map.get(testClass));
        map.put(new TestClass(1, "c"), 1);
        System.out.println(map.get(testClass));
        map.put(new TestClass(1, "d"), 1);
        map.put(new TestClass(1, "e"), 1);
        System.out.println(map.get(new TestClass(1, "d")));
        System.out.println(map.get(testClass));
    }

    @Test
    public void testString() throws NoSuchFieldException, IllegalAccessException {
        // ①常量池先创建"abcd" ②堆里再创建"abcd" ③堆里的引用返回给a
        String a = "abcd";
//        String a = new String("abcd");
        System.out.println("a: " + a);
        // 反射修改字符串值，改的是哪个？
        Class<? extends String> clazz = a.getClass();
        Field value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        char[] v = (char[]) value.get(a);
        v[0] = 'b';
        System.out.println("a: " + a);

//        String b = new String("abcd");
        String b = "abcd";
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a == b: " + (a == b));
        System.out.println("a.intern() == b: " + (a.intern() == b));
        System.out.println("a equals to b: " + (a.equals(b)));

        String c = "bbcd";
        System.out.println("a: " + a);
        System.out.println("c: " + c);
        System.out.println("a == c: " + (a == c));
        System.out.println("a equals to c: " + (a.equals(c)));

        clazz = c.getClass();
        value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        v = (char[]) value.get(c);
        v[0] = 'c';
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("a == b: " + (a == b));
        System.out.println("a == c: " + (a == c));
        System.out.println("b == c: " + (b == c));
        System.out.println("a equals to b: " + (a.equals(b)));
        System.out.println("a equals to c: " + (a.equals(c)));
        System.out.println("b equals to c: " + (b.equals(c)));

        System.out.println("abcd" == "bbcd");
        System.out.println("abcd" == "cbcd");
        System.out.println("bbcd" == "cbcd");
        System.out.println("abcd".equals("bbcd"));
        System.out.println("abcd".equals("cbcd"));
        System.out.println("bbcd".equals("cbcd"));
        System.out.println();
    }
}
