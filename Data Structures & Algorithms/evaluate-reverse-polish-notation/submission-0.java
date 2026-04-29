class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        Set<String> ops = new HashSet<>(List.of("+", "-", "*", "/"));

        for(String s : tokens) {
            if(ops.contains(s)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;

                if(s.equals("+")) {
                    res = num1 + num2;
                } else if(s.equals("-")) {
                    res = num2 - num1;
                } else if(s.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num2 / num1;
                }

                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
