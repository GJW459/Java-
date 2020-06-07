package com.gjw.study.one;

public class RootAdminRole implements RoleOperation {
    private String roleName;
    public RootAdminRole(String roleName){
        this.roleName=roleName;
    }

    @Override
    public String op() {
        return "AAA permission";
    }
}
