package backtracking;

import java.util.ArrayList;
import java.util.List;

public class safeQueen {

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        for (int r = row, c = col; r < n && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoard) {
        List<String> nBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += "Q";
                } else {
                    row += ".";
                }
            }
            nBoard.add(row);
        }
        allBoard.add(nBoard);
    }

    public static void sQueen(char[][] board, List<List<String>> allBoard, int col, int n) {
        if (col == n) {
            saveBoard(board, allBoard);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                sQueen(board, allBoard, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> allBoard = new ArrayList<>();
        sQueen(board, allBoard, 0, n);
        for (List<String> b : allBoard) {
            for (String row : b) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
