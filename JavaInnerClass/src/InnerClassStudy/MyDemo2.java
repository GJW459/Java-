package InnerClassStudy;

/**
 * 匿名内部类实现回调
 */
public class MyDemo2 {

    public void test(Demo3 demo3){
        System.out.println("test 匿名内部类实现回调");
    }

    public static void main(String[] args) {
        MyDemo2 myDemo2=new MyDemo2();
        myDemo2.test(new Demo3() {
            @Override
            public void demoMethod() {
                System.out.println("实现具体的接口!!!");
            }
        });
    }

}
