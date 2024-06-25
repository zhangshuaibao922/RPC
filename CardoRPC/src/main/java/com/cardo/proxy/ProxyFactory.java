package com.cardo.proxy;

import com.cardo.common.Invocation;
import com.cardo.common.URL;
import com.cardo.loadbalance.LoadBalance;
import com.cardo.protocol.HttpClient;
import com.cardo.register.MapRemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {
    public static <T> T getProxy(Class interfaceClass) {
        //用户配置
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(),
                        method.getName(),
                        method.getParameterTypes(),
                        args);
                HttpClient httpClient = new HttpClient();

                //服务发现
                List<URL> urls = MapRemoteRegister.get(interfaceClass.getName());

                //负载均衡
                URL url = LoadBalance.random(urls);
                String result=null;
                //服务调用
                try{
                    result = httpClient.send(url.getHostname(), url.getPort(), invocation);

                }catch (Exception e){
                    return "报错";
                }

                return result;
            }
        });
        return (T) proxyInstance;
    }
}
