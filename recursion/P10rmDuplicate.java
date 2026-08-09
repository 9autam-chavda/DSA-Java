package recursion;

public class P10rmDuplicate {
    static boolean[] chararr = new boolean[26];
    public static void rmDuplicate(String s, int idx, String newS) {
        if (idx == s.length()) {
            System.out.println(newS);
            return;
        }
        char currchar = s.charAt(idx);
        if (chararr [currchar-'a']) {}
        else {
            newS += currchar;
            chararr [currchar-'a'] = true;   
        }
        rmDuplicate(s, idx+1, newS);
    }
    public static void main(String[] args) {
        System.out.println("10052025");
        String s = "gautam";
        rmDuplicate(s, 0, "");
    }
    
}
