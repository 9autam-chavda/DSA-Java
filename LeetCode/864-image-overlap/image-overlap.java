class Solution {
    public int helper(int arr[][],int brr[][],int row_Offset,int col_Offset){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
              int x=i+row_Offset;
              int y=col_Offset+j;
              if(x<0||x>=n||y<0||y>=n) continue;
              if(arr[i][j]==1&&brr[x][y]==1) count++;
            }
        }
        return count;
    }
    public int largestOverlap(int[][] arr, int[][] brr) {
        int max=0;
        int n=arr.length;
        for(int i=-n+1;i<n;i++){
            
            for(int j=-n+1;j<n;j++){
               int count=helper(arr,brr,i,j);
               max=Math.max(max,count);
            }
        }
        return max;
    }
}