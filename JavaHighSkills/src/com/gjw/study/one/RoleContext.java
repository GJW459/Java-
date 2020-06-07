package com.gjw.study.one;

/**
 * 在工厂模式的基础之上 按照策略模式的思想 创建一个策略上下文
 */
public class RoleContext {

    //可更换策略,传入不同的策略对象,业务响应变化
    private RoleOperation roleOperation;

    public RoleContext(RoleOperation roleOperation){
        this.roleOperation=roleOperation;
    }
    public String execute(){
        return roleOperation.op();
    }
}
