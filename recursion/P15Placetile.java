// place tiles of size 1*m in a floor of size m*n; m=4, n=2 so count ways to place!

package recursion;

public class P15Placetile {
    public static int placetile (int m, int n) {
        if (m>1 || n>1) {
            if (m==n) {
                return 2;
            }
            if (m<n) {
                return 1;
            }
        }
        else
        {
             return 0;
        }

        int verticalplace = placetile(m-n, n);
        int horizontalplace = placetile(m-1, n);

        return verticalplace+horizontalplace;
    }

    public static void main(String[] args) {
        System.out.println("010620025");
        int m=4, n=4;
        System.out.println(placetile(m, n));
    }
}


// some eror in this  code in m==n case it shows only 2 is answer
