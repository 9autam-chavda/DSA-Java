package backtracking;

public class permutation {
    public static void printpermutation (String str, String Permutation) {
        if (str.length()==0) {
            System.out.println(Permutation);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char currchar = str.charAt(i);
            String nS = str.substring(0, i) + str.substring(i+1);
            printpermutation(nS, Permutation+currchar);
        }
        
    }
    public static void main(String[] args) {
        String str = "gautam";
        printpermutation(str, "");
    }
}
