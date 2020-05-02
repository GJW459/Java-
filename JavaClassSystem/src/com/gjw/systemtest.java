package com.gjw;


import java.math.BigDecimal;
import java.math.BigInteger;

public class systemtest {

    public static void main(String[] args) {
        String javaVersion = System.getProperty("java.version");
        String property = System.getProperty("java.home");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String username = System.getProperty("user.name");
        String home = System.getProperty("user.home");
        String dir = System.getProperty("user.dir");
        System.out.println(javaVersion);
        System.out.println(property);
        System.out.println(osName);
        System.out.println(osVersion);
        System.out.println(username);
        System.out.println(home);
        System.out.println(dir);
        System.out.println("================");
        BigInteger bigInteger=new BigInteger("111111111111111111111111111111111111111111111111111111111111111111111111111");
        BigDecimal bigDecimal=new BigDecimal("123456.321");
        BigDecimal bigDecimal2=new BigDecimal("11");
        System.out.println(bigInteger);
        System.out.println(bigDecimal.divide(bigDecimal2,BigDecimal.ROUND_HALF_UP));
        System.out.println(bigDecimal.divide(bigDecimal2,25,BigDecimal.ROUND_HALF_UP));


    }
}
