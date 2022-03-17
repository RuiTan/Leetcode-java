package collection.proxy;

public class SmsServiceImpl1 implements SmsService{
    @Override
    public void send(String message) {
        System.out.println("SmsServiceImpl1.send " + message);
    }
}
