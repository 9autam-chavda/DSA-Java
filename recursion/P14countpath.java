package recursion;

public class P14countpath {
    public static int countpath (int i, int j, int n, int m ){
        if (i == m-1 || j == n-1) {
            return 1;
        }
        
        if ( i==m && j==n )
        { return 0;}
        // for row 
        int count1 = countpath(i+1, j, n, m);
        // for collum 
        int count2 = countpath(i, j+1, n, m);

        return count1+count2;
    }


    public static void main(String[] args) {
        System.out.println("010620025");
        int n=3, m=3;
        int path = countpath(0, 0, n, m);
        System.out.println(path);
    }
}
