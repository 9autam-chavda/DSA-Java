class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;       
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    
                    while (!q.isEmpty()) {
                        int[] idx = q.poll();
                        int r = idx[0];
                        int c = idx[1];

                        if (r > 0 && grid[r - 1][c] == '1' && !visited[r - 1][c]) {
                            visited[r - 1][c] = true; 
                            q.add(new int[]{r - 1, c});
                        }
                        
                        if (r < n - 1 && grid[r + 1][c] == '1' && !visited[r + 1][c]) {
                            visited[r + 1][c] = true;
                            q.add(new int[]{r + 1, c});
                        }
                        
                        if (c > 0 && grid[r][c - 1] == '1' && !visited[r][c - 1]) {
                            visited[r][c - 1] = true;
                            q.add(new int[]{r, c - 1});
                        }
                        
                        if (c < m - 1 && grid[r][c + 1] == '1' && !visited[r][c + 1]) {
                            visited[r][c + 1] = true;
                            q.add(new int[]{r, c + 1});
                        }
                    }
                }
            }
        }
        return count; 
    }
}
