package InnerClassStudy;

import java.util.ArrayList;
import java.util.List;

public class OuterClass {

    private String string="abc";

    public Sequence getSequence(){
        return new Sequence();
    }
    private class Sequence{

        public List<OuterClass> getOuterclasses(){
            List<OuterClass > outerClasses=new ArrayList<>();
            for (int i=0;i<10;i++){
                outerClasses.add(new OuterClass());
            }
            return outerClasses;
        }
    }
    @Override
    public String toString() {
        return "OuterClass{" +
                "string='" + string + '\'' +
                '}';
    }

    public static void main(String[] args) {

        OuterClass outerClass=new OuterClass();
        OuterClass.Sequence sequence=outerClass.getSequence();
        List<OuterClass> outerclasses = sequence.getOuterclasses();
        for (OuterClass outerclass : outerclasses) {
            System.out.println(outerClass.string);
        }
    }
}
