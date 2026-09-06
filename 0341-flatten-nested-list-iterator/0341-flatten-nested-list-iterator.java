/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        // Add elements in reverse order
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        hasNext(); // Make sure the top is an integer
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        // Keep expanding lists until top is an integer
        while (!stack.isEmpty()) {

            NestedInteger top = stack.peek();

            if (top.isInteger()) {
                return true;
            }

            // Remove the nested list
            stack.pop();

            List<NestedInteger> list = top.getList();

            // Add elements in reverse order
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */