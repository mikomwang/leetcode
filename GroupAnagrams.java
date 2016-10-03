public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> KeyVals = new HashMap<String, ArrayList<String>>();
        for (String str: strs) {
            ArrayList temp;
            ArrayList newList;
            if (KeyVals.containsKey(Sorted(str))) {
              temp = KeyVals.get(Sorted(str));
              temp.add(str);
            } else {
                newList = new ArrayList<String>();
                newList.add(str);
                HashMap.put(Sorted(str), newList);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> list: KeyVals.getValues()) {
            result.add(list);
        }
        return result;
    }
    
    public String Sorted(String str) {
        str.sort();
        return str;
    }
}