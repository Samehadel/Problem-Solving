import java.util.*;

public class ValidParentheses {
    private static HashMap<Character, Character> charPairs = new HashMap<>(); // Holds the pairs of parentheses

    public static void main(String [] args){

        String s = "{}(]";
        //String s = "{}[]";
        //String s = "[{(()}]";
        //String s = ")";
        //String s = ")(){}";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();

        if(s.length() < 2)
            return false;

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);

            if(isOpen(c))
                chars.push(c);
            else
                if(!chars.isEmpty() && isOpposite(chars.peek(), c))
                    chars.pop();
                else
                    chars.push(c);

        }
        return chars.isEmpty();
    }

    public static boolean isOpen(Character c){
        if(c.equals('{') || c.equals('(') || c.equals('['))
            return true;

        return false;
    }

    public static boolean isOpposite(Character open, Character close){

        if(charPairs.isEmpty()){
            charPairs.put('{', '}');
            charPairs.put('(', ')');
            charPairs.put('[', ']');
        }

        return close.equals(charPairs.get(open)); // True if close bracket opposite to open bracket
    }
}
