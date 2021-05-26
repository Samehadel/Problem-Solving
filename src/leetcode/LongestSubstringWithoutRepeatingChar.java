/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String s  = "sfksatt"; 
        
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> chars = new HashSet<>();

        int startIndex = 0;
        int lastIndex = 0;
        int maxLength = 0;

        while (lastIndex < s.length()) {
            char c = s.charAt(lastIndex);

            if (!chars.contains(c)) {
                chars.add(c);
                maxLength = Math.max(maxLength, chars.size());
                lastIndex++;
            } else {
                chars.remove(s.charAt(startIndex));
                startIndex++;
            }
        }

        return maxLength;
    }

}
