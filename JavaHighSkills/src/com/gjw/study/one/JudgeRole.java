package com.gjw.study.one;

/**
 * 正常的后台管理都会涉及所谓的角色的概念
 * 不同用户管理员的权限不一样，所能做的操作也不一样
 * ROLE_ROOT_ADMIN A操作
 * ROLE_ORDER_ADMIN B操作
 * ROLE_NORMAL C操作
 */
public class JudgeRole {

    /**
     * 常用的if else ...
     * 这样写明显不优雅 几十个角色就难顶了
     * 改进代码 学会使用枚举
     * 除了枚举 还有使用工厂模式解决if else 策略模式也可以解决=>符合开闭原则 增加写代码 而不需要改变以前的业务代码
     * 默认根据角色民判断有哪些行为
     *
     * @param roleName 角色名
     * @return
     */
    public String judge(String roleName) {
        String result = "";
        if ("ROLE_ROOT_ADMIN".equals(roleName)) {
            result = "AAA permission";
        } else if ("ROLE_ORDER_ADMIN".equals(roleName)) {
            result = "BBB permission";
        } else if ("ROLE_NORMAL_ADMIN".equals(roleName)) {
            result = "CCC permission";
        } else {
            result = "xxx";
        }
        return result;

    }

    /**
     * 使用枚举解决多if else 的情况
     *
     * @param roleName
     * @return
     */
    public String judge2(String roleName) {
        return RoleEnum.valueOf(roleName).op();
    }

    /**
     * 工厂模式
     *
     * @param roleName
     * @return
     */
    public String judge3(String roleName) {
        return RoleFactory.getOp(roleName).op();
    }

    /**
     * 策略模式
     *
     * @param roleOperation
     * @return
     */
    public String judge4(RoleOperation roleOperation) {
        RoleContext roleContext = new RoleContext(roleOperation);
        return roleContext.execute();
    }

    public static void main(String[] args) {
        JudgeRole judgeRole = new JudgeRole();
        //枚举的测试
        String result1 = judgeRole.judge2("ROLE_ROOT_ADMIN");
        //工厂模式的测试
        String result2 = judgeRole.judge3("ROLE_ORDER_ADMIN");
        //策略模式的测试
        String result3 = judgeRole.judge4(new NormalRole("ROLE_NORMAL_ADMIN"));
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
