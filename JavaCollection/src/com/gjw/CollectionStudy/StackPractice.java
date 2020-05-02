package com.gjw.CollectionStudy;

public class StackPractice {

    /**
     * 判断是不是字母
     * @return
     */
    public static boolean IsLetter(char letter){
        if ((letter>='a'&&letter<='z')||(letter>='A'&&letter<='Z')){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        Stack<Character> characterStack = new Stack<>();
        char[] chars = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s".toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='+'&&StackPractice.IsLetter(chars[i+1])){
                characterStack.push(chars[i+1]);
            }else if ((i+1)<chars.length){
                if (chars[i+1]=='-'&&!characterStack.empty()){
                    System.out.print(characterStack.pop());
                }
            }
        }
    }
}
