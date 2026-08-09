package recursion;

public class P12keypadCombination {
    static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printcombination (String S, int idx, String combination) {
        if (idx == S.length()) {
            System.out.println(combination);
            return;
        }
        char currChar = S.charAt(idx);
        String mapping = keypad[currChar-'0'];
        for (int i =0; i<mapping.length(); i++) {
            printcombination(S, idx+1, combination+mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
        System.out.println("10052025");
        String S = "23";
        printcombination(S, 0, "");
    }
}
