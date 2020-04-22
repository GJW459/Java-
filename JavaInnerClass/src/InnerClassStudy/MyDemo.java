package InnerClassStudy;

/**
 * 内部类实现多继承
 */
public class MyDemo {


    private class Test1 extends Demo1{
        @Override
        public String name() {
            return super.name();
        }
    }
    public class Test2 extends Demo2{
        @Override
        public String email() {
            return super.email();
        }
    }
    public String name(){
        return new Test1().name();
    }
    public String email(){
        return new Test2().email();
    }

    public static void main(String[] args) {

        MyDemo myDemo=new MyDemo();
        System.out.println(myDemo.name());
        System.out.println(myDemo.email());
    }
}
