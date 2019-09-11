package studyForJob;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 实现括号是否匹配
 * Created by ZXL on 2019/8/29.
 */
public class s_05 {
    private static boolean isMatch(String str) {
        if (str == null || str.length() == 0) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        int len = str.length();
        for (int i = 0; i < len; i++) {
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
}
