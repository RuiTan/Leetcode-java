package concurrent;

import collection.serializable.User;
import org.openjdk.jol.info.ClassLayout;

public class SynchronizedDemo {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("t");
        System.out.println(ClassLayout.parseInstance(sb).toPrintable());
        for (int i = 0; i < 10; i++){
            synchronized (sb){
                System.out.println(ClassLayout.parseInstance(sb).toPrintable());
            }
        }
//        new Thread(()->{
//            for (int i = 0; i < 10; i++){
//                try {
//                    Thread.sleep(100);
//                    System.out.println(ClassLayout.parseInstance(sb).toPrintable());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    sb.append("a");
//                }
//            }
//        }).start();
//        new Thread(()->{
//            for (int i = 0; i < 10; i++){
//                try {
//                    Thread.sleep(100);
//                    System.out.println(ClassLayout.parseInstance(sb).toPrintable());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    sb.append("b");
//                }
//            }
//        }).start();
        System.out.println(ClassLayout.parseInstance(sb).toPrintable());

        System.out.println(sb.toString());
    }
}
