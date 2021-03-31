package leetcode;

/*
Problem:
Given a sorted array of distinct integers and a target value, 
return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 */


public class SearchInsert {

    public static void main(String[] args) {
        int[] arr = {1, 7, 9, 11, 15, 22, 25, 30};
        //int [] arr = {1};
        System.out.println(searchInsert(arr, 16));
    }

    public static int searchInsert(int[] nums, int target) {

        if (target <= 1 || target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        return findIndex(nums, 0, nums.length - 1, target);

    }

    public static int findIndex(int[] nums, int low, int high, int target) {
        int mid = (low + high) / 2;

        while (low <= high) {

            mid = (low + high) / 2;

            int value = nums[mid];

            if (value == target) {
                return mid;
            }

            //Look ahead
            if (mid + 1 < nums.length) {
                if (nums[mid + 1] > target && value < target) {
                    return mid + 1;
                }
            }

            //Look back
            if (mid - 1 >= 0) {
                if (nums[mid - 1] < target && value > target) {
                    return mid;
                }
            }

            //Modify low or high
            if (target < value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return mid;
    }
}
