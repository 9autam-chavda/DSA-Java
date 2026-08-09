package recursion;
import java.util.Scanner;

public class P4fibonacci {
    public static void printFibonacci(int n, int nextturm, int a, int b) {
        if (n==0) {
            return;
        }
        nextturm=a+b;
        System.out.println(nextturm);
        printFibonacci(n-1,nextturm,b,nextturm);

    }
    public static void main(String[] args) {
        System.out.println("04052025");
        Scanner sc = new Scanner(System.in);
        int a=0;
        int b=1;
        int nextturm = 1;
        System.out.print("enter number fibonacci turm :");
        int n = sc.nextInt();
        System.out.println("0");
        System.out.println("1");
        printFibonacci(n-2, nextturm,a,b);
        sc.close();
    }   
}
