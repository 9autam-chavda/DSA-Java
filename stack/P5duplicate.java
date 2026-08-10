package stack;
import java.util.Stack;

public class P5duplicate {

    public static boolean isDuplicate(String str) {
        Stack<Character> ch = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char currch = str.charAt(i);

            if (currch == ')') {
                int count = 0;
                while (ch.peek() != '(') {
                    ch.pop();
                    count++;
                }
                if(count<1) {
                    return true;
                }
                else {
                    ch.pop();
                }
            }
            else {
                ch.push(currch);
            }
        }

        return false;
    }
   public static void main(String[] args) {
    String str = "((a+b) + (c + d))";
    String str1 = "((a+b))";

    System.out.println(isDuplicate(str));
    System.out.println(isDuplicate(str1));
   } 
}
