class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;
    int min;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();

        if(!minStack.isEmpty()) {
            min = minStack.peek();
        } else {
            min = Integer.MAX_VALUE;
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
