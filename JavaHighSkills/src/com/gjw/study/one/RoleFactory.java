package com.gjw.study.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类 对不同的角色进行聚合
 */
public class RoleFactory {
    private final static Map<String, RoleOperation> roleOperationMap = new HashMap<>();

    //静态块里面做完全部的初始化
    static {

        roleOperationMap.put("ROLE_ROOT_ADMIN", new RootAdminRole("ROLE_ROOT_ADMIN"));
        roleOperationMap.put("ROLE_ORDER_ADMIN", new OrderAdminRole("ROLE_ORDER_ADMIN"));
        roleOperationMap.put("ROLE_NORMAL_ADMIN", new NormalRole("ROLE_NORMAL_ADMIN"));
    }

    public static RoleOperation getOp(String roleName) {
        //获取指定操作
        return roleOperationMap.get(roleName);
    }
}
