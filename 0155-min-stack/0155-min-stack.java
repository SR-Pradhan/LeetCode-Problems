class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {

        // Push value into the main stack
        stack.push(value);

        // Store the minimum value at this stack level
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            minStack.push(Math.min(minStack.peek(), value));
        }
    }

    public void pop() {

        // Remove from both stacks to keep them synchronized
        stack.pop();
        minStack.pop();
    }

    public int top() {

        // Return the top element without removing it
        return stack.peek();
    }

    public int getMin() {

        // Top of minStack always contains the current minimum
        return minStack.peek();
    }
}
