package recursion;

public class P13permutation {
    public static void permutation(String str, String permutation ) {
        if (str.length() == 0 ) {
            System.out.println(permutation);
            return ;
        }

        for (int i = 0; i<str.length(); i++) {
            char currchar = str.charAt(i);
            String nString = str.substring(0, i) + str.substring(i+1);
            permutation(nString, permutation+currchar);
        }
    }

    public static void main(String[] args) {
        System.out.println("010620025");
        String str = "ab";
        permutation(str, "");
        System.out.println(str.charAt(2));
    }  
}

/* time complexity of this code 
    O(n!)
 */




 


  
