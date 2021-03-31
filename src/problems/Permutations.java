package problems;

/*
Problem:
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            array.add(nums[i]);
        }

        return permute(array);
    }

    public List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();

        //Base Case
        if (nums.size() == 1) {
            List<Integer> base = new ArrayList<>();
            List<List<Integer>> baseBack = new ArrayList<>();

            base.add(nums.get(0));
            baseBack.add(base);
            return baseBack;
        }

        for (int i = 0; i < nums.size(); i++) {
            //Drop first element
            int n = nums.remove(0);

            //Recurse
            List<List<Integer>> perms = permute(nums);

            for (int j = 0; j < perms.size(); j++) 
                perms.get(j).add(n);
            

            for (int k = 0; k < perms.size(); k++) 
                result.add(perms.get(k));
            
            nums.add(n);

        }

        return result;
    }

}
