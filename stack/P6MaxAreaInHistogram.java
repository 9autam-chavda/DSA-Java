package stack;

import java.util.Stack;

public class P6MaxAreaInHistogram {

    public static void maxArea (int[] hightOfGraph) {
        int[] rightMin = new int[hightOfGraph.length];
        int[] leftMin = new int [hightOfGraph.length];

        // Finding right min
        Stack<Integer> S = new Stack<>();
        for (int i= hightOfGraph.length-1; i>=0; i--) {
            while (!S.isEmpty() && hightOfGraph[S.peek()] >= hightOfGraph[i] ) {
                S.pop();
            }

            if(S.isEmpty()) {
                rightMin[i] = hightOfGraph.length;
            }
            else {
                rightMin[i] = S.peek();
            }

            S.push(i);
        }

        // Finding left min
        S = new Stack<>();
        for (int i=0; i<=hightOfGraph.length-1; i++) {
            while (!S.isEmpty() && hightOfGraph[S.peek()] >= hightOfGraph[i] ) {
                S.pop();
            }

            if(S.isEmpty()) {
                leftMin[i] = -1;
            }
            else {
                leftMin[i] = S.peek();
            }

            S.push(i);
        }

        // Finding max area
        int maxarea = Integer.MIN_VALUE;
        for (int i=0; i<hightOfGraph.length; i++) {
            int width = rightMin[i] - leftMin[i] -1;
            int area = hightOfGraph[i] * width;
            maxarea = Math.max(maxarea, area);
        }

        System.out.println("maximum area ractanle area is : " + maxarea);
    }
    public static void main(String[] args) {
        int[] hightOfGraph = {2,1,5,6,2,3};
        maxArea(hightOfGraph);
    }
}
