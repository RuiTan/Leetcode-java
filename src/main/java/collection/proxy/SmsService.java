package collection.proxy;

public interface SmsService {
    void send(String message);

    public static void main(String[] args) {
        SmsService smsService1 = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl1());
        SmsService smsService2 = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl2());
        smsService1.send("java");
        smsService2.send("java");

        SmsServiceImpl1 smsServiceImpl1 = (SmsServiceImpl1) CglibProxyFactory.getProxy(SmsServiceImpl1.class);
        smsServiceImpl1.send("java");
    }
}
