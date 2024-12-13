package com.bigdata.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name ProxyFactory
 * @create 2024/7/19 6:42
 */

//动态代理类
public class ProxyFactory {
    //目标类对象
    private Object target;

    //有参构造器
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //使用jdk动态代理,java.lang.reflect包
    public Object getProxy() {
        /**
         * ClassLoader loader,指定加载动态生成的代理类的类加载器
         * Class<?>[] interfaces,和目标类实现相同接口继承关系,存储了这些Class的数组
         * InvocationHandler h,实现继承接口中的相关抽象方法,此时要调用目标对象的抽象方法,同时添加新增的功能
         */
        ClassLoader loader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy代理对象,method要执行的方法,args参数列表
                //执行目标对象方法
                Object result = null;
                try {
                    System.out.println("前置通知");
                    method.invoke(target, args);
                    System.out.println("返回通知");
                }catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常通知");
                }finally {
                    System.out.println("后置通知");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(loader,interfaces,h);
    }
}
