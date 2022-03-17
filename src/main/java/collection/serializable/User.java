package collection.serializable;

import lombok.*;
import sun.jvm.hotspot.utilities.ObjectReader;

import java.io.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Externalizable {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private transient int age;
    @Getter
    @Setter
    private int height;

    private static void SerializeUser() throws IOException {
        User user = new User("tanrui", 10, 180);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./user"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        System.out.println(user.toString());
    }

    private static void DeSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("./user");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        User user = (User) objectInputStream.readObject();
        System.out.println(user.toString());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("tanrui", 10, 180);
//        Reader reader = new CharArrayReader(user.getName().toCharArray());
//        while (reader.ready()){
//            System.out.println((char) reader.read());
//        }
//        reader.close();


    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
        out.writeObject(height);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (Integer) in.readObject();
        height = (Integer) in.readObject();
    }
}
