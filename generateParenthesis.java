public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> parenList = new ArrayList<String>();
        helper(parenList, "", 0, 0, n);
        return parenList;
    }
    
    public void helper(ArrayList<String> list, String accumulate, int open, int close, int max) {
        if (accumulate.length() == max * 2) {
            list.add(accumulate);
            return;
        }
        if (open < max) {
            helper(list, accumulate + "(", open + 1, close, max);
        }
        if (close < open) {
            helper(list, accumulate + ")", open, close + 1, max);
        }
    }
}