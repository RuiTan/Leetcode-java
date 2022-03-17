package collection.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class HashSetDemo {
    @AllArgsConstructor
    static class User {
        @Getter
        @Setter
        private String name;
        @Getter
        @Setter
        private int age;
        @Getter
        @Setter
        private int number;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return number == user.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", number=" + number +
                    '}';
        }
    }

    public static void main(String[] args) {
        Set<User> set = new HashSet<>();
        User user1 = new User("tanrui1", 18, 1);
        set.add(user1);
        System.out.println(set);
        User user2 = new User("tanrui2", 18, 2);
        set.add(user2);
        System.out.println(set);
        User user3 = new User("tanrui3", 18, 1);
        set.add(user3);
        System.out.println(set);

        Map<User, Integer> map = new HashMap<>();
        map.put(user1, 1);
        System.out.println(map);
        map.put(user2, 2);
        System.out.println(map);
        map.put(user3, 3);
        System.out.println(map);
    }

}
