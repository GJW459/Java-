package InnerClassStudy;

//局部内部类
public class Outer2 {

    //在局部可以创建内部类对象，通过对象调用方法
    private int age=20;
    public void method(){
        class Inner{
            private int age2=20;
            public void show(){
                System.out.println(age);
                System.out.println(age2);
            }

        }
        Inner inner=new Inner();
        inner.show();
    }

    public static void main(String[] args) {
        Outer2 outer2=new Outer2();
        outer2.method();
    }
}
