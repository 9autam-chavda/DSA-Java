public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1); 
        
        int[] bestTill = new int[n];
        
        int INF = 1000000000; 
        Arrays.fill(bestTill, INF);
        
        int currentSum = 0;
        int minCombinedLength = INF;
        int shortestSingleLen = INF;
        
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            prefixMap.put(currentSum, i);
            
            int neededSum = currentSum - target;
            
            if (prefixMap.containsKey(neededSum)) {
                int startIdx = prefixMap.get(neededSum);
                int currentLen = i - startIdx;
                
                shortestSingleLen = Math.min(shortestSingleLen, currentLen);
                
                if (startIdx >= 0 && bestTill[startIdx] != INF) {
                    minCombinedLength = Math.min(minCombinedLength, bestTill[startIdx] + currentLen);
                }
            }
            
            bestTill[i] = shortestSingleLen;
        }
        
        return minCombinedLength >= INF ? -1 : minCombinedLength;
    }
}
