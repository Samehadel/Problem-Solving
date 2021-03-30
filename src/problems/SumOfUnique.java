package problems;

import java.util.HashMap;

/*
You are given an integer array nums. The unique elements of an array are the elements that appear exactly once
in the array. Return the sum of all the unique elements of nums.
*/

public class SumOfUnique {
    
    public static int sumOfUnique(int[] nums) {
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            
            if(!map.containsKey(value)){
                sum += value;
                map.put(value, true);
            }else{
                if(map.get(value)){
                    sum -= value;
                    map.put(value, false);
                }
            }
        }
        return sum;
    }
}
