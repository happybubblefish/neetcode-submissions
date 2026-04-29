class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return res;
    }
}
