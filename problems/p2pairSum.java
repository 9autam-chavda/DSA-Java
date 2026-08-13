package problems;

import java.util.ArrayList;

public class p2pairSum {

    public static void check(ArrayList<Integer> al, int target) {
        int bp = -1;
        int n=al.size();
        for(int i=0; i<al.size(); i++) {
            if (al.get(i)>al.get(i+1)) {
                bp = i;
                break;
            }
        }

        int lp = bp+1;
        int rp = bp;
         
        while (rp!=lp) {
            //case1
            if (al.get(lp)+al.get(rp)==target){
                System.out.println(al.get(lp)+" "+ al.get(rp));
                System.out.println("true");
            }
            //case2
            if (al.get(lp)+al.get(rp)<target) {
                lp = (lp+1)%n;
            }
            else {
                rp = (n+rp-1)%n;
            }
        }

        System.out.println("target answer not exist!");
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(11);
        al.add(15);
        al.add(6);
        al.add(8);
        al.add(9);
        al.add(10);

        int target = 16;
        check(al, target);

    }
}
