public class Solution {
    
    public String reverseWords(String s) {
        if (s.equals("")) {
            return "";
        }
        String reversedString = reverse(s);
        String[] splitted = reversedString.split("\\s+");
        String newString = reverseWords(splitted);
        return newString;
    }
    
    public String reverse(String s) {
        StringBuilder newString = new StringBuilder();
        for (int i = s.length(); i > 0; i -= 1) {
            newString.append(s.charAt(i - 1));
        }
        return newString.toString();
    }
    
    public String reverseWords(String[] s) {
        StringBuilder result = new StringBuilder();
        int numWords = s.length;
        String originalWord;
        for (String word: s) {
            originalWord = reverse(word);
            result.append(originalWord);
            numWords -= 1;
            if (numWords != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}