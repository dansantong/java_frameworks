package com.service;

/**
 * 业务类
 */

public class ProductService {
    //根据xml，这个函数是切入点PointCut
    public void doSomeService(){
        System.out.println("doSomeService");
    }
}
