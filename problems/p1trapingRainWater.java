package problems;

public class p1trapingRainWater {

    public static int trapedWater(int[] hight) {
        int n = hight.length;
        
        // left max boundary
        int[] leftMax = new int[n];
        leftMax[0]= hight[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], hight[i]);
        }

        // right max boundary
        int[] rightMax = new int[n];
        rightMax[n-1] = hight[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], hight[i]);
        }

        int trapedWater = 0;

        for(int i=0; i<n; i++) {
            int waterlevel = Math.min(rightMax[i], leftMax[i]);

            trapedWater+= waterlevel - hight[i];
        }

        return trapedWater;

    }

    public static void main(String[] args) {
        int[] hight = {4, 2, 0, 6, 3, 2, 5};

        System.out.println(trapedWater(hight));
    }
}
