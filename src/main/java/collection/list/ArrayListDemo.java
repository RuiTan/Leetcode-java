package collection.list;

import java.util.Arrays;

public class ArrayListDemo {
    private static final Object[] defaultArray = {};
    private Object[] array1;
    private Object[] array2;

    public static void main(String[] args) {
        ArrayListDemo arrayListDemo = new ArrayListDemo();
        arrayListDemo.array1 = defaultArray;
        arrayListDemo.array2 = defaultArray;
        arrayListDemo.array1[0] = 1;
        arrayListDemo.array2[0] = 2;
        System.out.println(Arrays.toString(arrayListDemo.array1));
        System.out.println(Arrays.toString(arrayListDemo.array2));
        System.out.println(Arrays.toString(ArrayListDemo.defaultArray));

    }
}
