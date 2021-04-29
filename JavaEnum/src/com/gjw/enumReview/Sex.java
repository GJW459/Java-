package com.gjw.enumReview;

public enum Sex implements info {
    FEMALE("女性") {
        @Override
        public void gotoWC() {
            System.out.println("蹲着上");
        }
    },
    MALE("男性") {
        @Override
        public void gotoWC() {
            System.out.println("站着上");
        }
    };
    private String sexName;

    Sex(String sexName) {
        this.sexName = sexName;
    }

    public String getSexName() {
        return sexName;
    }

}
