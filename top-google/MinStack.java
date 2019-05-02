/**
    Min Stack

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
 */

// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.

import java.util.ArrayDeque;
import java.util.Deque;

// Space Complexity: O(N)   N = size of stack + size of minStack 
public class MinStack {
    // use a stack to keep the minimum value until current stack
    Deque<Integer> stack, minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    // Time Complexity: O(1)
    public void push(int x) {
        stack.addFirst(x);
        minStack.addFirst((minStack.size() == 0 || x < minStack.peekFirst()) ? x : minStack.peekFirst());
    }
    
    // Time Complexity: O(1)
    public void pop() {
        if (stack.size() == 0)  
            return;
        stack.removeFirst();
        minStack.removeFirst();
    }
    
    // Time Complexity: O(1)
    public int top() {
        if (stack.size() == 0)  
            return -1;
        return stack.peekFirst();
    }
    
    // Time Complexity: O(1)
    public int getMin() {
        if (minStack.size() == 0)  
            return -1;
        return minStack.peekFirst();
    }
}
