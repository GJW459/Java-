package InnerClassStudy;

/**
 * static内部类
 */
public class Outer5 {

    private int age=15;
    private static int age2=20;
    static class Inner{
        public void show(){
            System.out.println(age2);//只能调用static成员
        }
    }

    public static void main(String[] args) {
        Outer5.Inner inner=new Outer5.Inner();
        inner.show();
    }
}
