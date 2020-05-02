package com.gjw.Dao;

import java.util.List;

/**
 * DAO 数据访问对象
 * 泛型的使用场景
 */
public class MyDao<T> {//所有表的DAO操作
    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(int index){
        return false;
    }
    //修改一条记录
    public void  update(int index,T t){

    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getForList(){
        return null;
    }
    /**
     * 泛型方法
     */
    public <E> E getValue(){
        return null;
    }
}
