public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        Deque<int[]> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            
            while (!stack.isEmpty() && currentTemp > stack.peek()[1]) {
                int[] poppedDay = stack.pop();
                int prevIdx = poppedDay[0];
                
                result[prevIdx] = i - prevIdx;
            }
            
            stack.push(new int[]{i, currentTemp});
        }
        
        return result;
    }
}
