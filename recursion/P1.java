package recursion;
import java.util.Scanner;

public class P1 {
    public static void printNum (int n) {
        if(n==0) {
            return;
        }
        System.out.println(n);
        printNum(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("04052025");
        int n ;
        n = sc.nextInt();
        printNum(n);
        sc.close();
    }
}
