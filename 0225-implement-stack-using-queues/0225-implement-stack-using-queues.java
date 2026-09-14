class MyStack {

    Queue<Integer> main;
    Queue<Integer> temp;

    public MyStack() {
        main = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void push(int x) {

        // Add the new element first
        temp.add(x);

        // Move all old elements behind the new element
        while (!main.isEmpty()) {
            int value = main.remove();
            temp.add(value);
        }

        // Swap the queue references
        Queue<Integer> swap = main;
        main = temp;
        temp = swap;
    }

    public int pop() {
        // Top element is always at the front
        return main.remove();
    }

    public int top() {
        // Return top without removing it
        return main.peek();
    }

    public boolean empty() {
        return main.isEmpty();
    }
}