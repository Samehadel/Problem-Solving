package leetcode;

/*
Problem: 
Given an integer array nums,find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.
*/
/*
Runtime: 2 ms, faster than 13.62% of Java online submissions for Maximum Subarray.
Memory Usage: 39 MB, less than 37.30% of Java online submissions for Maximum Subarray.
 */
public class MaximumSubarray {

    public static void main(String[] args) {

        //int [] theArray = {-2, 5, 3, -5, 10, 2, -2, 11, -23, 2};
        //int[] theArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] theArray = {1};
        //int[] theArray = {5, -1, 2};
        //int[] theArray = {5,4,-1,7,8};
        //int[] theArray = {-2, 1};
        //int[] theArray = {-1,0,-2};
        //int[] theArray = {1,-1,1};
        int[] theArray = {2, -3, 0, 1, -2, -3, -1};

        System.out.println(maxSubArray(theArray));
    }

    public static int maxSubArray(int[] nums) {
        return findMaximumSubarray(nums, 0, nums.length - 1);
    }

    public static int findMaximumSubarray(int[] A, int low, int high) {

        if (low == high) {
            return A[low];
        }

        int mid = (low + high) / 2;

        int leftPart = findMaximumSubarray(A, low, mid);
        int rightPart = findMaximumSubarray(A, mid + 1, high);
        int crossPart = findMaxCrossingSubarray(A, low, high);

        if (leftPart >= rightPart && leftPart >= crossPart) {
            return leftPart;
        } else if (rightPart >= leftPart && rightPart >= crossPart) {
            return rightPart;
        } else {
            return crossPart;
        }
    }

    public static int findMaxCrossingSubarray(int[] A, int low, int high) {
        if (low == high) {
            return A[low];
        }

        int sum = 0;
        int leftSum = (int) Double.NEGATIVE_INFINITY;
        int rightSum = (int) Double.NEGATIVE_INFINITY;

        int mid = (low + high) / 2;
        int maxLeft = mid;
        int maxRight = mid + 1;

        for (int i = mid; i >= low; i--) {
            sum += A[i];

            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;

        for (int j = mid + 1; j <= high; j++) {
            sum += A[j];

            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        int totalSum = leftSum + rightSum;

        if (totalSum >= leftSum && totalSum >= rightSum) {
            return totalSum;
        } else if (leftSum > totalSum) {
            return leftSum;
        } else if (rightSum > totalSum) {
            return rightSum;
        }
        return 0;
    }
}
