package collection.proxy;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static Object getProxy(Object target){
        DebugInvocationHandler handler = new DebugInvocationHandler(target);
        ClassLoader targetClassLoader = target.getClass().getClassLoader();
        ClassLoader handlerClassLoader = handler.getClass().getClassLoader();
        System.out.println(targetClassLoader);
        System.out.println(handlerClassLoader);
        return Proxy.newProxyInstance(
                targetClassLoader,
                target.getClass().getInterfaces(),
                handler
        );
    }
}
