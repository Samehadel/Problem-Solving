public class SearchInRotatedSortedArray {

    public static void main(String [] args){
/*
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
*/

/*
        int [] nums = {5,7,9,2,3};
        int target = 3;
*/


        int [] nums = {1, 3, 5};
        int target = 3;

        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {

        // For simple arrays smaller than 3 elements
        if(nums.length < 3) {
            for (int i = 0; i < nums.length; i++)
                if(nums[i] == target) return i;

            return -1;
        }

        // No rotation applied to the array. Apply BS directly
        if(nums[0] < nums[nums.length - 1])
            return binarySearchTarget(nums, 0, nums.length - 1, target);

        // Last index before order of the array change
       int lastIndex = binarySearchLastIndex(nums) - 1;

       // Search the right sub-array
       if(nums[lastIndex] >= target && target >= nums[0])
           return binarySearchTarget(nums, 0, lastIndex, target);
       else
           return binarySearchTarget(nums, lastIndex + 1, nums.length - 1, target);
    }

    /*
        For example: [4, 5, 6, 1, 2, 3]
        return index: 2 as the value: 6 is the last value before the split of the array
     */
    public static int binarySearchLastIndex(int [] nums){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int v = nums[0];

        while(low <= high){
            mid = (low + high) / 2;

            if(nums[mid] >= v)
                low = mid + 1;
            else if (low == mid)
                return mid;
            else
                high = mid;

        }
        return -1;
    }

    public static int binarySearchTarget(int [] nums, int low, int high, int target){
        int mid = 0;

        while(low <= high){
            mid = (low + high) / 2;

            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        if(nums[mid] == target)
            return mid;

        return -1;
    }
}
