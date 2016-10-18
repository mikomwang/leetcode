/*
 * Complete the function below.
 */

    static String[] buildSubsequences(String s) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < s.length(); i += 1) { 
            for (int j = i+1; j < s.length() + 1; j += 1) {
                result.add(s.substring(i, j));
            }
        }
        String[] answer = new String[result.size()];
        answer = result.toArray(answer);
        Arrays.sort(answer);
        return answer;

    }

