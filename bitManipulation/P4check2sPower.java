package bitManipulation;

public class P4check2sPower {
    public static boolean check (int n) {
        /*
        short
        return (n&(n-1)) == 0;
        */ 

        if ((n&(n-1))==0) {
            return true;
        } 
        else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(check(16));
    }
}
