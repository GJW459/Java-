package InnerClassStudy;

/**
 * 匿名内部类
 */
interface Inner{
     void show();
}
public class Outer4 {

    public void method(){
        new Inner(){

            @Override
            public void show() {

                System.out.println("哈哈哈");
            }
        }.show();
    }

    public static void main(String[] args) {
        Outer4 outer4=new Outer4();
        outer4.method();
    }
}
