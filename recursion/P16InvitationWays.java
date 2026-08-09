// find the number of ways in which you can invite 'n' people to your party, single or in pairs

package recursion;

public class P16InvitationWays {
    public static int ways (int n) {

        if (n<=1) {
            return 1;
        }

        int single = ways(n-1);
        int pair = (n-1)*ways(n-2);
        
        return single+pair;
    }

    public static void main(String[] args) {
        System.out.println("010620025");
        int n = 3;
        System.out.println(ways(n));
    }
}
