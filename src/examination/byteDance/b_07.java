package examination.byteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给个字符串，只有(){}[]，看看是否是匹配的
 * Created by ZXL on 2019/8/15.
 */
public class b_07 {
    public static boolean isMatch(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == map.get(c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("(***)-[{-------}]")); //true
        System.out.println(isMatch("(2+4)*a[5]")); //true
        System.out.println(isMatch("({}[]]])")); //false
        System.out.println(isMatch("())))")); //false
    }
}
