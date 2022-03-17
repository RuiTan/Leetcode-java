package collection.proxy;

import lombok.AllArgsConstructor;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CglibProxyTest {
    public static class MailService {
        public void send(String message){
//            System.out.println("send: " + message);
        }
    }

    static class MailMethodInterceptor implements MethodInterceptor{
        @Override
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//            System.out.println("before invoke super " + method.getName());
            Object result = methodProxy.invokeSuper(proxy, args);
//            System.out.println("after invoke super " + method.getName());
            return result;
        }
    }

    @AllArgsConstructor
    static class MailInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(proxy.getClass().getSuperclass().newInstance(), args);
        }
    }

    public static class CglibProxyFactory{
        public static Object getProxy(Class clazz){
            Enhancer enhancer = new Enhancer();
            enhancer.setClassLoader(clazz.getClassLoader());
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(new MailMethodInterceptor());
//            enhancer.setCallback(new MailInvocationHandler());
            return enhancer.create();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Long> times = new LinkedList<>();
        Thread.sleep(2000);
        for (int j = 0; j < 100; j++) {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++){
                MailService service = (MailService) CglibProxyFactory.getProxy(MailService.class);
                service.send("Hello");
            }
            long endTime = System.currentTimeMillis();
            times.add(endTime - startTime);
            System.out.println(endTime-startTime);
        }
        System.out.println(times);
    }
}
