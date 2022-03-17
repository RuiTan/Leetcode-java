package collection.proxy;

public class SmsServiceImpl2 implements SmsService{
    @Override
    public void send(String message) {
        System.out.println("SmsServiceImpl2.send " + message);
    }
}
