/**
 * FileName: UserCompratar
 * Author:   郭经伟
 * Date:     2020/4/9 17:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gjw.collection;

import java.util.Comparator;

public class UserCompratar implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {

        //如果两个人的第一个字母相同
        if (o1.getNumber().charAt(0)==o2.getNumber().charAt(0)){
            //比较后面的字母
            Integer number1 = Integer.parseInt(o1.getNumber().substring(1));
            Integer number2 = Integer.parseInt(o2.getNumber().substring(1));
            return Integer.compare(number1,number2);
        }
        if (o1.getNumber().charAt(0)=='V'){
            //如果a>b 返回1，降序
            //如果a>b，返回-1 升序
            return -1;
        }else {
            return 1;
        }

    }
}
