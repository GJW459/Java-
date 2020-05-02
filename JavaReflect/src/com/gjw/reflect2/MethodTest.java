package com.gjw.reflect2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法
 */
public class MethodTest {

    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //getMethods:获取当前运行时类及所有父类声明的public方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //getDeclaredMethods:获取当前类实例的所有方法,不包括父类方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    /**
     * @Xxxxx
     * 权限修饰符 返回值类型 方法名(参数1,参数2....) throws XxxException{}
     */
    @Test
    public void test2(){

        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("开始");
            //1.获取方法上声明的注解 只能获取运行时注解
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //2.权限修饰符
            int modifiers = declaredMethod.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //3.返回值类型
            Class<?> returnType = declaredMethod.getReturnType();
            System.out.println(returnType.getName());
            //4.方法名
            System.out.println(declaredMethod.getName());
            //5,方法参数,形参列表
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if (!(parameterTypes==null&&parameterTypes.length==0)){
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println(parameterType.getName());
                }
            }
            //6.抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if (!(exceptionTypes==null&&exceptionTypes.length==0)){
                for (Class<?> exceptionType : exceptionTypes) {
                    System.out.println(exceptionType.getName());
                }
            }

        }
    }
}
