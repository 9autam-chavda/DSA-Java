package recursion;

public class P9movX {
    static int idx = 0;
    static int count = 0;
    public static void movx(String s, int idx, int count, String newS) {
        if (idx == s.length()) {
            for (int i=1; i<=count; i++){
                newS += "x";
            }
            System.out.println(newS);
            return;
        }
        if (s.charAt(idx)=='x') {
            count++;
        }
        else {
            newS += s.charAt(idx);
        }
        movx(s, idx+1, count, newS);

        
    }

    public static void main(String[] args) {
        System.out.println("090520025");
        String s = "gaxxutaxm";
        movx(s, 0, 0, "");
    }
}
