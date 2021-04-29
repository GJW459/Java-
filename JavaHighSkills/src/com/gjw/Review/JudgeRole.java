package com.gjw.Review;

/**
 * 后台管理系统一般都涉及多个角色
 * 如果我们要判断哪个角色执行哪个操作
 * 最简单的就是一个judge函数使用if else来进行判断，这就有一个问题，几个角色还好，多个就比较麻烦了
 * 我们的常用的方法是使用枚举和工厂模式来解决这种问题
 */
public class JudgeRole {


    /**
     * 枚举解决多if else的问题
     * @param roleName
     * @return
     */
    public String judge(String roleName){
        return RoleEnum.valueOf(roleName).op();
    }

    public static void main(String[] args) {
        JudgeRole judgeRole = new JudgeRole();
        String result = judgeRole.judge("ROOT_ADMIN_ROLE");
        System.out.println(result);
    }
}
