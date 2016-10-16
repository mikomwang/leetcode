public class Solution {
    ArrayList<String> result = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() == 0) {
            return result;
        }
        backtrackHelper(s, "", 4);
        return result;
    }
    
    public void backtrackHelper(String s, String accumulated, int count) {
        if (s.length() == 0 && count == 0) {
            result.add(accumulated.substring(0, accumulated.length()-1));
            return;
        }
        if (s.length() == 0 || count == 0) {
            return;
        }
        String sub;
        for (int i = 1; i <= s.length(); i += 1) {
            sub = s.substring(0, i);
            if (isValid(sub)) {
                backtrackHelper(s.substring(i), accumulated + sub + ".", count - 1);
            } else {
                break;
            }
        }
    }
    
    public boolean isValid(String s) {
        int val = Integer.valueOf(s);
        if (val > 255) {
            return false;
        } else {
            return s.length() == String.valueOf(val).length();
            
        }
    }
}