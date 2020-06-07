package com.gjw.study.one;

public enum RoleEnum implements RoleOperation {

    ROLE_ROOT_ADMIN{
        @Override
        public String op() {
            return "AAA permission";
        }
    },
    ROLE_ORDER_ADMIN{
        @Override
        public String op() {
            return "BBB permission";
        }
    },
    ROLE_NORMAL_ADMIN{
        @Override
        public String op() {
            return "CCC permission";
        }
    }
}
