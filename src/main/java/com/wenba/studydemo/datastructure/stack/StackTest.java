package com.wenba.studydemo.datastructure.stack;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/22 4:37 下午
 * @description：
 */
public class StackTest {
    private static Stack stack = new Stack();
    public static void main(String[] args) {
       /* String str = "how are you";
        System.out.println(reverse(str));*/
        String str = "12<a[b{c}]";
        match(str);
    }

    public static void match(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch (c){
                case '<' :
                case '[' :
                case '{' :
                    stack.push(c);
                    break;
                case '}' :
                case ']' :
                case '>' :
                    if(!stack.empty()){
                        char cha = stack.pop().toString().toCharArray()[0];
                        if ((c == '}' && cha != '{') || (c == ']' && cha != '[')
                        || (c == '<' && cha != '>')){
                            throw new RuntimeException("不匹配");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static String reverse(Object str){
        String string = str.toString();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
