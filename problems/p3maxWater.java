package problems;

// in this we have to a find the maximum water stored between the bars
// we have bar hight of each bar in an array

import java.util.ArrayList;



public class p3maxWater {

    public static int Mwater (ArrayList<Integer> bar) {
        int maxWater = 0;
        for (int i=0; i<bar.size(); i++) {
            for(int j=i+1; j<bar.size(); j++) {
                int hight = Math.min(bar.get(i), bar.get(j));
                int width = j-i;

                int water = hight*width;

                maxWater = Math.max(maxWater, water);
            }
        }

        return maxWater;
    }

    // better approach

    public static int Mwater2 (ArrayList<Integer> bar) {
        int maxWater = 0;
        int lp = 0;
        int rp = bar.size()-1;

        while(lp<rp) {
            int hight = Math.min(bar.get(lp), bar.get(rp));
            int width = rp-lp;
            int water = hight*width;
            maxWater = Math.max(maxWater, water);

            if (bar.get(lp)<bar.get(rp)) {
                lp++;
            }
            else{
                rp--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList <Integer> bar = new ArrayList<>();
        bar.add(1);
        bar.add(8);
        bar.add(6);
        bar.add(2);
        bar.add(5);
        bar.add(4);
        bar.add(8);
        bar.add(3);
        bar.add(7);

    int maxWater = Mwater2(bar);

        System.out.println("max water can store is : " + maxWater);
    }
}
