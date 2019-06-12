package examination.tencent;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * Created by ZXL on 2019/6/12.
 */
public class t_18 {
    public static boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                char topChar = stack.isEmpty() ? '#' : stack.pop();
                if (topChar != hashMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("(])]"));
        System.out.println(isValid("{[]}"));
    }
}
