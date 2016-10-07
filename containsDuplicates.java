public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniques = new HashSet<Integer>();
        for (Integer val: nums) {
            uniques.add(val);
        }
        if (uniques.size() == nums.length) {
            return false;
        }
        return true;
    }
}