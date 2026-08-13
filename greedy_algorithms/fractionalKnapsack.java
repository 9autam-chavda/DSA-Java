package greedy_algorithms;

import java.util.*;

public class fractionalKnapsack {
   public static void main(String[] args) {

    int[] values = {60, 100, 120};
    int[] weights = {10, 20, 30};
    int capacity = 60;

    double[][] ratio = new double[values.length][2];
    for(int i=0; i<values.length; i++) {
        ratio[i][0] = i;
        ratio[i][1] = (double) (values[i]/weights[i]);
    }

    // sorting in ascending order
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int finalvalue = 0;

    for(int i=ratio.length-1; i>=0; i--) {
        if (capacity>= weights[i]) {
            finalvalue += values[i];
            capacity -= weights[i]; 
        }
        else {
            finalvalue += (ratio[i][1]*capacity);
            capacity = 0; 
        }
    }

    System.out.println("final value: " + finalvalue);

   } 
}
