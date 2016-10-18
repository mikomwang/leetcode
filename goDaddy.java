/*
 * Complete the function below.
 */

    static String[] missingWords(String s, String t) {
        int counter = 0;
        int stopPos = -1;
        String[] sentence = s.split("\\s+");
        String[] wordPool = t.split("\\s+");
        for (int i = 0; i < sentence.length; i += 1) {
            if (!wordPool[counter].equals(sentence[i])) {
                continue;
            }
            sentence[i] = null;
            counter += 1;
            if (counter == wordPool.length) {
                stopPos = counter;
                break;
            }
        }
        if (stopPos != -1) {
            for (int j = stopPos; j < sentence.length; j+=1){
               sentence[j] = null;
            }
        }
        int realLength = 0;
        for (String nullWord: sentence) {
            if (nullWord != null) {
                realLength += 1;
            }
        }
        String[] results = new String[realLength];
        int index = 0;
        for (int i = 0; i < realLength; i += 1) {
            if (sentence[i] != null) {
                results[index] = sentence[i];
                index += 1;
            }
        }
        return results;
    } 

