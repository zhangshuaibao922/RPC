package com.cardo;

import com.cardo.common.URL;
import com.cardo.protocol.HttpServer;
import com.cardo.register.LocalRegister;
import com.cardo.register.MapRemoteRegister;

public class Provider {
    public static void main(String[] args) {
        //本地注册
        LocalRegister.regist(HelloService.class.getName(),"1.0", HelloServiceImpl.class);
        //注册中心注册  服务注册
        URL url = new URL("localhost",8888);
        MapRemoteRegister.regist(HelloService.class.getName(),url);

        //支持接受网络请求：netty？ Tomcat？ Socket？
        HttpServer httpServer=new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());
    }
}
