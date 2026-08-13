package greedy_algorithms;

import java.util.*;

public class chocola {
    public static void main(String[] args) {
        Integer[] vercost = {2, 1, 3, 1, 4};
        Integer[] horcost = {4, 1, 2}; 

        Arrays.sort(vercost, Collections.reverseOrder());
        Arrays.sort(horcost, Collections.reverseOrder());
        

        int h=0, v=0;
        int hp=1, vp=1;
        int cost = 0;

        while (v < vercost.length && h < horcost.length) {
            if (vercost[v] <= horcost[h]) {
                cost +=  (horcost[h] * vp);
                hp++;
                h++;
            }
            else {
                cost += (vercost[v] * hp);
                vp++;
                v++;
            }
        }

        while (v < vercost.length) {
            cost += (vercost[v] * hp);
            vp++;
            v++;
        }

        while (h < horcost.length) {
            cost += (horcost[h] * vp);
            hp++;
            h++;
        }

        System.out.println("minimum cost is : " + cost);

    }
}

/*
 * This code implements a greedy algorithm to find the minimum cost of cutting a chocolate bar.
 * in this problem, we have vertical and horizontal cuts with associated costs.
 * with this associated costs we have to find the minimum cost of cutting the chocolate bar. 
 */
