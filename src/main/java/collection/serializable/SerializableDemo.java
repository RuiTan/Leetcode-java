package collection.serializable;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SerializableDemo {
    @Getter
    @Setter
    int val;

    @Getter
    @Setter
    int age;

    public SerializableDemo(){}

    public SerializableDemo(int val, int age) {
        this.val = val;
        this.age = age;
    }

    private int getAge(){
        return age;
    }
    public int getVal(){
        return val;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(val);
    }
    @Override
    public boolean equals(Object demo){
        return demo instanceof SerializableDemo && (((SerializableDemo) demo).age == age);
    }

    @Override
    public String toString() {
        return "SerializableDemo{" +
                "val=" + val +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        SerializableDemo demo1 = new SerializableDemo(1, 2);
//        SerializableDemo demo2 = new SerializableDemo(1, 3);
//        System.out.println(demo1 == demo2);
//        System.out.println(demo1.equals(demo2));
//        System.out.println(demo1.hashCode());
//        System.out.println(demo2.hashCode());
//        Map<SerializableDemo, Integer> map = new HashMap<>();
//        map.put(demo1, 1);
//        map.put(demo2, 2);
//        System.out.println(map);
//
        User user = new User("tanrui", 1, 2);
        System.out.println(user);

        ArrayList<String> strings = new ArrayList<>();
        Class<?> s = strings.getClass();
        Method method = s.getMethod("add", Object.class);
        method.invoke(strings, 1);
        method.invoke(strings, "ab");
        method.invoke(strings, 3);
        method.invoke(strings, user);
        System.out.println(Arrays.toString(strings.toArray()));
        for (Object o : strings){
            System.out.println(o.getClass());
        }
    }
}
