class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        int fStart = intervals[0][0];
        int fEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int sStart = intervals[i][0];
            int sEnd = intervals[i][1];

            if (fEnd >= sStart) {
                fEnd = Math.max(fEnd, sEnd); 
            } else {
                list.add(new int[]{fStart, fEnd}); 
                fStart = sStart;
                fEnd = sEnd; 
            }
        }

        list.add(new int[]{fStart, fEnd});

        return list.toArray(new int[list.size()][]);
    }
}
