public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i += 1) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('{') || c.equals('[')) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (stack.peek().equals('(') && c.equals(')')) {
                stack.pop();
            } else if (stack.peek().equals('[') && c.equals(']')) {
                stack.pop();
            } else if (stack.peek().equals('{') && c.equals('}')) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;   
        } else {
            return false;
        }
    }
}