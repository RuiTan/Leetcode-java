package collection.proxy;

import lombok.AllArgsConstructor;
import org.openjdk.jmh.annotations.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JdkProxyTest {

    public interface MailService {
        void send(String message);
    }

    public static class MailServiceImpl implements MailService {

        @Override
        public void send(String message) {
//            System.out.println("send " + message);
        }
    }

    @AllArgsConstructor
    public static class MailInvocationHandler implements InvocationHandler{
        private final Object target;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(target, args);
            return result;
        }
    }

    public static class JDKProxyFactory{
        public static Object getProxy(Object o){
            return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new MailInvocationHandler(o));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MailServiceImpl serviceImpl = new MailServiceImpl();
        MailService service = (MailService) JDKProxyFactory.getProxy(serviceImpl);
        service.send("hello");
    }
}
