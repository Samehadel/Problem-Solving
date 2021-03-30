/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALKODS
 */
public class Permutations {
    
    
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int period = factorial(n) / n;
        int c = 0;
        boolean lock = true;
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> paths = fillInitial(n);
        
        
        
        
        
        for(int i = 0; i < period; i++){
           
        }
        return result;
    }
    public static List<Integer> fillInitial(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(i);
            
        return list;
    }
    public static int factorial(int n) {
    int fact = 1;
    for (int i = 2; i <= n; i++) {
        fact = fact * i;
    }
    return fact;
}
    
}
