class Solution {
    public int calculate(String s) {
        int n = s.length();
        int num = 0;
        char prevOp = '+';

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Build number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Process operator or last character
            if ((!Character.isDigit(ch) && ch != ' ')
                    || i == n - 1) {

                if (prevOp == '+') {
                    stack.push(num);
                } else if (prevOp == '-') {
                    stack.push(-num);
                } else if (prevOp == '*') {
                    stack.push(stack.pop() * num);
                } else if (prevOp == '/') {
                    stack.push(stack.pop() / num);
                }

                prevOp = ch;
                num = 0;
            }
        }

        int result = 0;

        for (int value : stack) {
            result += value;
        }

        return result;
    }
}