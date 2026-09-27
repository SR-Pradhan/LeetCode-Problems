import java.util.Stack;

class StockSpanner {

    Stack<int[]> stk = new Stack<>();
    int index = 0;

    public StockSpanner() {
    }
    
    public int next(int price) {

        // Remove previous prices <= current price
        while(!stk.isEmpty() && stk.peek()[0] <= price){
            stk.pop();
        }

        int span;

        // No greater price on the left
        if(stk.isEmpty()){
            span = index + 1;
        }else{
            // Nearest greater price blocks the span
            span = index - stk.peek()[1];
        }

        // Store current price and its index
        stk.push(new int[]{price, index});
        index++;

        return span;
    }
}