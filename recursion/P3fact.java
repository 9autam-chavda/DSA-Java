package recursion;
import java.util.Scanner;

public class P3fact {
    public static void sum(int n, int fact) {
        if (n == 0 ) {
            System.out.println(fact);
            return;
        }
        fact *= n;
        sum(n-1, fact); 
    }
    public static void main(String[] args) {
        System.out.println("04052025");
        int fact=1;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter num for factorial : ");
        int n = sc.nextInt();
        sum(n, fact);
        sc.close();
    }
}