package recursion;
import java.util.HashSet;

public class P11subSequences {
    public static void subSequence (String S, int idx, String newS) {
        if (idx == S.length()) {
            System.out.println(newS);
            return;
        }

        char currChar = S.charAt(idx);
        
        // if we want to add char
        subSequence(S, idx+1, newS+currChar);
        // if we dont want to add char
        subSequence(S, idx+1, newS);
    }

    public static void hashsetSubs (String S, int idx, String newS, HashSet<String> set) {
        if (idx == S.length()) {
            if (set.contains(newS)) {
                return;
            }
            else {
                System.out.println(newS);
                set.add(newS);
                return;
            }
        }

        char currChar = S.charAt(idx);
        
        // if we want to add char
        hashsetSubs(S, idx+1, newS+currChar, set);
        // if we dont want to add char
        hashsetSubs(S, idx+1, newS, set);
    }
    public static void main(String[] args) {
        System.out.println("10052025");
        String S = "abcd";
        HashSet<String> set = new HashSet<String>();
        subSequence(S, 0, "");
        hashsetSubs("aaa", 0, "", set);
    }
}

/* time complexity of this type code is 
  == O(2^n)
 */
