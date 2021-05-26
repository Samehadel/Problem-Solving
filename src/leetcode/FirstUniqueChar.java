import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static void main(String [] args){

        //String test = "leetcode";
        //String test = "loveleetcode";
        //String test = "dddccdbba";
        //String test = "ddbba";
        //String test = "aabbca";
        String test = "lesisessl";

        System.out.println(findFirstUniqueChar(test));

    }

    public static int findFirstUniqueChar(String word){
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            charCount.merge(word.charAt(i), 1, (a, b) -> a + 1);
        }
        for(int i = 0; i < word.length(); i++){
            if(charCount.get(word.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
