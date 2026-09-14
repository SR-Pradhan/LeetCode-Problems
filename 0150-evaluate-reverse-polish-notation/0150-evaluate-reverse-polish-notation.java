class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stk = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {

                int a = stk.pop();
                int b = stk.pop();

                int result = b + a;
                stk.push(result);

            } else if (token.equals("-")) {

                int a = stk.pop();
                int b = stk.pop();

                int result = b - a;
                stk.push(result);

            } else if (token.equals("*")) {

                int a = stk.pop();
                int b = stk.pop();

                int result = b * a;
                stk.push(result);

            } else if (token.equals("/")) {

                int a = stk.pop();
                int b = stk.pop();

                int result = b / a;
                stk.push(result);

            } else {

                // Convert String number to integer
                int num = Integer.parseInt(token);
                stk.push(num);
            }
        }

        return stk.peek();
    }
}