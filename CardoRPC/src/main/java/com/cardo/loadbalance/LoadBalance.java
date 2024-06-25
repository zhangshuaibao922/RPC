package com.cardo.loadbalance;

import com.cardo.common.URL;

import java.util.List;
import java.util.Random;

public class LoadBalance {
    public static URL random(List<URL> urls){
        Random random=new Random();
        int i1 = random.nextInt(urls.size());
        return urls.get(i1);
    }
}
