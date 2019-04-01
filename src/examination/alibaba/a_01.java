package examination.alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZXL on 2019/4/1.
 * 属性字符串解析
 * <p>
 * 连续的K=V的字符串，每个K=V之间用”,”分隔，V中可嵌套K=V的连续字符串结构，
 * 例如"key1=value1,key2=value2,key3=[key4=value4,key5=value5,key6=[key7=value7]],key8=value8"
 * 请编写如下函数，给定字符串，输出嵌套结构的HashMap
 * 要求：不可使用递归
 */
public class a_01 {
    private static int[] getMark(String input) {
        int[] marks = new int[input.length()];
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                marks[i] = ++count;
            }
            if (input.charAt(i) == ']') {
                count--;
            }
            if (input.charAt(i) == '=' || input.charAt(i) == ',') {
                marks[i] = count;
            }
        }
        return marks;
    }


    private static HashMap<String, Object> parse(String input) {
        int[] marks = getMark(input);
        int maxMark = 0;
        for (int i = 0; i < input.length(); i++) {
            maxMark = Math.max(marks[i], maxMark);
        }
        HashMap<String, Object> result = new HashMap<>();
        List<List<Integer>> indexes = new ArrayList<>();
        int height = maxMark;
        while (height > 0) {
            List<Integer> maxIndexes = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                if (marks[i] == height) {
                    maxIndexes.add(i);
                }
            }
            indexes.add(0, maxIndexes);
            if (height == 1) {
                indexes.get(0).add(0, -1);
            }

            List<Integer> tempList = new ArrayList<>(indexes.get(0));
            while (!tempList.isEmpty()) {
                int left = tempList.remove(0);
                int equal = tempList.remove(0);
                int right = input.length();
                if (input.indexOf(',', equal) != -1 && input.indexOf(']', equal) != -1) {
                    right = Math.min(input.indexOf(',', equal), input.indexOf(']', equal));
                } else if (input.indexOf(',', equal) != -1) {
                    right = input.indexOf(',', equal);
                } else if (input.indexOf(']', equal) != -1) {
                    right = input.indexOf(']', equal);
                }
                if (height == maxMark) {
                    String key = input.substring(left + 1, equal);
                    String value = input.substring(equal + 1, right);
                    result.put(key, value);
                    marks[right] = 0;
                } else {
                    int leftRange = equal;
                    int rightRange = input.indexOf(']', leftRange);
                    if (tempList.size() != 0) {
                        rightRange = tempList.get(0);
                    }
                    List<Integer> valueKeyIndexes = new ArrayList<>();
                    for (Integer index : indexes.get(1)) {
                        if (index > leftRange && index < rightRange) {
                            valueKeyIndexes.add(index);
                        }
                    }
                    if (valueKeyIndexes.size() != 0) {
                        String key = input.substring(left + 1, equal);
                        HashMap<String, Object> tempMap = new HashMap<>();
                        int step = 2;
                        for (int i = 0; i + 1 < valueKeyIndexes.size(); i += step) {
                            String valueKey = input.substring(valueKeyIndexes.get(i) + 1, valueKeyIndexes.get(i + 1));
                            tempMap.put(valueKey, result.remove(valueKey));
                        }
                        result.put(key, tempMap);
                    } else {
                        String key = input.substring(left + 1, equal);
                        String value = input.substring(equal + 1, right);
                        result.put(key, value);
                    }
                }
            }
            height--;
        }
        return result;
    }

    public static void main(String[] args) {

        String input1 = "key1=value1,key2=value2,key3=[key4=value4,key5=value5,key6=[key7=value7]],key8=value8";
        System.out.println("输入1：" + input1);
        System.out.println("输出1：" + parse(input1));
        System.out.println();

        String input2 = "key1=value1,key2=value2,key3=[key4=[key9=value9,key10=value10],key5=value5,key6=[key7=value7]],key11=[key8=value8]";
        System.out.println("输入2：" + input2);
        System.out.println("输出2：" + parse(input2));
    }
}
