package vip.trgg;

import lombok.AllArgsConstructor;
import org.junit.Test;

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
}
