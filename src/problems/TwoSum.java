package problems;

import java.util.HashMap;


/*      * Test Cases *
        //int [] nums = {10, 2, 5, 7, 27, 30, 31, 11, 50, 25, 20};
        //int [] nums = {0, 1, 3, 2, 0};
        //int [] nums = {3, 3};
        //int [] nums = {2,5,5,11};
        //int [] nums = {2,7,11,15};
        //int [] nums = {3, 2, 4};
        //int target = ?

        //int[] ind = twoSum(nums, target);

*/
public class TwoSum {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
    Memory Usage: 38.9 MB, less than 79.22% of Java online submissions for Two Sum.
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (complements.get(nums[i]) == null) {
                complements.put(target - nums[i], i);
            } else {
                return new int[]{i, complements.get(nums[i])};
            }
        }
        return new int[]{};
    }
}
