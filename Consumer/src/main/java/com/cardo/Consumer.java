package com.cardo;

import com.cardo.proxy.ProxyFactory;

public class Consumer {
    public static void main(String[] args) {
        HelloService helloService= ProxyFactory.getProxy(HelloService.class);
        String s = helloService.sayHello("cardo");
        System.out.println(s);
//        Invocation invocation=new Invocation(HelloService.class.getName(),
//                "sayHello",
//                new Class[]{String.class},
//                new Object[]{"cardo"});
//        HttpClient httpClient = new HttpClient();
//        String result = httpClient.send("localhost", 8888, invocation);
//        System.out.println(result);
    }
}
