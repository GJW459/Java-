package InnerClassStudy;

/**
 * 局部内部类
 */
public class Outer3 {

    public void method(){
        boolean flag=true;
        if (flag){
            class Inner{

                public void show(){
                    System.out.println("嘻嘻嘻嘻");
                }
            }
            //在当前{}中内部类才有定义
            Inner inner=new Inner();
            inner.show();
        }
    }

    public static void main(String[] args) {
        Outer3 outer3=new Outer3();
        outer3.method();
    }
}
