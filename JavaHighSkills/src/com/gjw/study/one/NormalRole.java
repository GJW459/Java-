package com.gjw.study.one;

public class NormalRole implements RoleOperation {

    private String roleName;
    public NormalRole(String roleName){
        this.roleName=roleName;
    }
    @Override
    public String op() {
        return "CCC permission";
    }
}
