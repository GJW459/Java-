package InnerClassStudy;

/**
 * 成员内部类
 */
public class Outer {

    private String string;

    public Outer(String string) {
        this.string = string;
    }
    public Inner getInner(){
        return new Inner();
    }

    class Inner{

        public Outer getOuter(){
            return Outer.this;//生成外部类对象的引用
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public static void main(String[] args) {
        Outer outer=new Outer("gjw");
        Outer.Inner inner=outer.getInner();
        System.out.println(inner.toString());
        Inner inner1 = outer.new Inner();
        System.out.println(inner1.toString());
        Outer outer1 = inner1.getOuter();
        System.out.println(outer);//同一个引用
        System.out.println(outer1);
    }
}
