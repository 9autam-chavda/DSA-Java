class Solution {
    public int reverseDegree(String s) {
        int index=1,sum=0;
        for(char c:s.toCharArray()){
            int posi=26-(c-'a');
            sum+=(posi*index++);
        }
        return sum;
    }
}