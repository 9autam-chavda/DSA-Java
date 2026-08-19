class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                rows.put(row, rows.getOrDefault(row, 0)| (1 << (col - 2)));
            }
        }

        int answer = (n - rows.size()) * 2;

        for (int mask : rows.values()) {
            boolean left = (mask & 0b00001111) == 0;

            boolean middle = (mask & 0b00111100) == 0;

            boolean right = (mask & 0b11110000) == 0;

            if (left && right) {
                answer += 2;
            } else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}