package problems;

/*
Problem:
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
*/

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if(length1 > 0 && length2 == 0) return findMedian(nums1);
        if(length2 > 0 && length1 == 0) return findMedian(nums2);
        
        int [] totalArray = new int[length1 + length2]; 
        int ptr1 = 0; 
        int ptr2 = 0;
        int ptrTotal = 0; 
        
        while(ptr1 < length1 && ptr2 < length2){
            if(nums1[ptr1] <= nums2[ptr2]) totalArray[ptrTotal++] = nums1[ptr1++];
            else totalArray[ptrTotal++] = nums2[ptr2++];
        }
        
        while(ptr1 < length1) totalArray[ptrTotal++] = nums1[ptr1++];
        while(ptr2 < length2) totalArray[ptrTotal++] = nums2[ptr2++];

        
        return findMedian(totalArray);
        
    }
    
     public double findMedian(int [] theArray){
        int len = theArray.length;
        
        if(len % 2 == 0){
            int start = (len / 2) - 1;
            
            return (theArray[start] + theArray[start + 1]) / 2.0; 
        }else{
            return (double)(theArray[len / 2]);
        }
    }
}
