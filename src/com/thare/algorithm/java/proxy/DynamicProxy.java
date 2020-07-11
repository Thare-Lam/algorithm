package com.thare.algorithm.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String[] args) {
        ProxyHandler proxy = new ProxyHandler();
        Car car = (Car) proxy.bind(new Volvo());
        car.drive();
    }

}

class ProxyHandler implements InvocationHandler {

    Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("fill gas");
        result = method.invoke(target, args);
        System.out.println("stop");
        return result;
    }

}


