public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String currLine;
        String answer;
        String cmds;
        while (sc.hasNextLine()) {
            currLine = sc.nextLine();
            String[] parts = currLine.split("/");
            parts[0] = parts[0].replaceAll("\\s+", "");
            if (parts.length == 1) {
                answer = parts[0];
            } else {
                answer = parts[0];
                cmds = filterOperations(parts[1]);
                for (int i = 0; i < cmds.length(); i += 1) {
                    if (cmds.charAt(i) == 'R') {
                        answer = reverse(answer);  
                    } else if (cmds.charAt(i) == 'S') {
                        answer = simplify(answer);
                    }
                }
            }
            System.out.println(answer);
        }
    }
    
    /* Reverse the expression tree */
    public static String reverse(String s) {
        Stack<Character> holder = new Stack<Character>();
        Character val;
        for (int i = 0; i < s.length(); i += 1) {
            val = s.charAt(i);
            if (val == '(') {
                holder.push(')');
            } else if (val == ')') {
                holder.push('(');
            } else {
                holder.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        Character temp;
        while (!holder.isEmpty()) {
            temp = holder.pop();
            result.append(temp);
        }
        return result.toString();
    }
    
    /* Simplify the Expression Tree. */
    public static String simplify(String s) {
        boolean firstparens = false;
        StringBuilder result = new StringBuilder();
        if (s.isEmpty()) {
            return "";
        } else {
            for (int i = 0; i < s.length(); i += 1) {
                 if (s.charAt(0) == '(' && i == 0 && !firstparens) {
                     firstparens = true;
                 } else if (s.charAt(i) == ')'&& firstparens) {
                     continue;
                 } else if (s.charAt(i) == '(' && firstparens) {
                     String recursiveResult = simplify(s.substring(i+1));
                     result.append(recursiveResult);
                     return result.toString();
                 } else {
                     result.append(s.charAt(i));
                 }
            }
        }
        return result.toString();
    }
    
    /** Filter the duplicate operations that occur in a row. */
    public static String filterOperations(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        boolean sawDoubleR = false;
        for (int i = 0; i < s.length() - 1; i += 1) {
            if (sawDoubleR) {
                sawDoubleR = false;
                continue;
            }
            else if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == 'R' && s.charAt(i + 1) == 'R') {
                sawDoubleR = true;
                continue;
            } else if (s.charAt(i) == s.charAt(i + 1)) {
                continue;
            } else {
                result.append(s.charAt(i));
            }
        }
        if (!sawDoubleR) {
            result.append(s.charAt(s.length() - 1));
        }
        return result.toString();
    }
}