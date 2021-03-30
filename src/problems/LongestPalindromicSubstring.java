package problems;

import java.util.HashSet;


public class LongestPalindromicSubstring {

    private static HashSet<String> lookUp = new HashSet<>();

    public static void main(String[] args) {
        String s = "caba";
        System.out.println(findCrossLongestPalindrome(s, 0, s.length() - 1));
    }

    public static String findLongestPalindrome(String s, int low, int high){
        
        
        if(low == high) return s.substring(low, high +1 ); //Base Case
        
        int mid = (low + high) / 2;
        
        String longestLeft = findLongestPalindrome(s, low, mid);
        String longestRight = findLongestPalindrome(s, mid + 1, high);
        String longestCross = findCrossLongestPalindrome(s, low, high);
        
        int leftLen = longestLeft.length();
        int rightLen = longestRight.length();
        int crossLen = longestCross.length();
        
        if(leftLen >= rightLen && leftLen >= crossLen)
            return longestLeft;
        else if(rightLen >= leftLen && rightLen >= crossLen)
            return longestRight;
        else
            return longestCross;
        
    }
    
    public static String findCrossLongestPalindrome(String s, int low, int high){
        
        
        int mid = (low + high) / 2;
        String crossPal = s.substring(mid, mid + 1);
        
        //System.out.println("Inital Cross : " + crossPal);
        
        int i = mid;
        int j = mid + 1;
        
        while(i >= low){
            while(j <= high){
                
            }
        }
        
        return crossPal;
    }
    public static boolean isPalindromic(String s, int low, int high) {
        
        System.out.println("Check For: " + s.substring(low, high + 1));
        int len = (high - low) + 1;
        if ((high - low) + 1 <= 1) 
            return true;
        /*
        if (lookUp.contains(s.substring(low, high + 1))) 
        {
            System.out.println("In Lookup");
            return true;
        }*/
        
        
        //Manual check
        int shift = 1; 
        
        for(int i = high; i > high - (len / 2); i--){
            int checkIndex = (i - len) + shift;
            shift += 2;
            
            //System.out.println("Chech: " + s.charAt(i) + " to " + s.charAt(checkIndex));
            if(s.charAt(i) != s.charAt(checkIndex)){ 
                //System.out.println("Not Equal");
                return false;
            }
        }
        
        //lookUp.add(s);
        
        return true;
    }

    /*
    public String longestPalindrome(String s) {
        
    }*/
}
