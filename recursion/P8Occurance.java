package recursion;

public class P8Occurance {
        static int firstidx = -1;
        static int lastidx = -1;
    public static void occurance(String s, int idx, char element) {
        if (idx == s.length()) {
            System.out.println(firstidx);
            System.out.println(lastidx);
            return;
        }
        char currChar = s.charAt(idx);
        if (currChar == element) {
            if (firstidx == -1) {
                firstidx = idx;
            }
            else{
                lastidx = idx;
            }
        }
        occurance(s, idx+1, element);
    }
    public static void main(String[] args) {
        System.out.println("090520025");
        String s = "abcbbbd"; 
        occurance(s, 0, 'b');
    }
}
