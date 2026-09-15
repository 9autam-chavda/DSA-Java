public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left_min = new int[n];
        int[] right_min = new int[n];
        
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]) {
                leftStack.pop();
            }

            left_min[i] = leftStack.isEmpty() ? -1 : leftStack.peek();
            leftStack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[i]) {
                rightStack.pop();
            }

            right_min[i] = rightStack.isEmpty() ? n : rightStack.peek();
            rightStack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right_min[i] - left_min[i] - 1;
            int currentArea = heights[i] * width;
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }
}
