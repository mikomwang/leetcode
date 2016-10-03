public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> KeyVals = new HashMap<String, List<String>>();
        for (String str: strs) {
            ArrayList temp;
            if Sorted(str) in KeyVals.keys() {
              temp = KeyVals.get(Sorted(str));
              temp.add(str);
            } else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(str);
                HashMap.put(str, temp);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> list: KeyVals.getValues()) {
            result.add(list);
        }
        return result;
    }
    
    public String Sorted(String str) {
        \\ Sorts a given string.
    }
}