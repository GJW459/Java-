package com.gjw.study.one;

public class OrderAdminRole implements RoleOperation {

    private String roleName;
    public OrderAdminRole(String roleName){
        this.roleName=roleName;
    }

    @Override
    public String op() {
        return "BBB permission";
    }
}
