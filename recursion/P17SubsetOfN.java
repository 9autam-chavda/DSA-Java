// print all the subset of a set of a set of first 'n' natural numbers ;

package recursion;
import java.util.ArrayList;

public class P17SubsetOfN {

    public static void print (ArrayList<Integer> subset) {
        for(int i=0; i<subset.size(); i++) {
            System.out.print(subset.get(i));
        }
        System.out.println();
    }
    
    public static void printSubset (int n, ArrayList<Integer> subset) {
        if (n==0)
        {
            print(subset);
            return;
        }

        // if we want to add   
       subset.add(n);
       printSubset(n-1, subset);

       //if you dont want to add
        subset.remove(subset.size()-1);
        printSubset(n-1, subset);
    }
    
    public static void main(String[] args) {
        int n =5
        ;
        ArrayList<Integer> subset = new ArrayList<Integer>();
        printSubset(n, subset);
    }
}