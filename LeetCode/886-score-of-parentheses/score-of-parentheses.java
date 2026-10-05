class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(0);
            } else {
                int inner = stack.pop();

                int score = (inner == 0) ? 1 : 2 * inner;

                int top = stack.pop();
                stack.push(top + score);
            }
        }

        return stack.pop();
    }
}