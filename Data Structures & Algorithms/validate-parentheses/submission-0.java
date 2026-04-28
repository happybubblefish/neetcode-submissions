class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char peek = stack.peek();

                if(c == ')' && peek != '(' || c == ']' && peek != '[' || c == '}' && peek != '{') {
                    return false;
                } else if(c == ')' && peek == '(' || c == ']' && peek == '[' || c == '}' && peek == '{') {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
