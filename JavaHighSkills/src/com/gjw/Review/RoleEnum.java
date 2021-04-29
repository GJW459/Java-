package com.gjw.Review;

public enum RoleEnum implements RoleOperation {

    ROOT_ADMIN_ROLE(){
        @Override
        public String op() {
            return "A op";
        }
    },
    ORDER_ADMIN_ROLE(){
        @Override
        public String op() {
            return "B op";
        }
    },
    NORMAL_ADMIN_ROLE(){
        @Override
        public String op() {
            return "C op";
        }
    }
}
