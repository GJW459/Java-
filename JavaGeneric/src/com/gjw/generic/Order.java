package com.gjw.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义泛型类
 */
public class Order<T> {
    String orderName;
    int orderId;
    //类的内部就可以使用类的泛型
    T orderT;
    public Order(String orderName,int orderId,T t){
        this.orderName=orderName;
        this.orderId=orderId;
        this.orderT=t;
    }
    public  Order(){

    }
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    /**
     * 泛型方法的泛型和类的泛型没有任何关系
     * 泛型方法为static的时候是允许的。原因：泛型参数是在调用方法的时候确定的，并不是实例化的时候确定的
     * @param arr 数组
     * @param <E> 泛型类型
     * @return 返回List
     */
     static  <E> List<E> copy(E[]arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}
