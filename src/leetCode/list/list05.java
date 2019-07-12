package leetCode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * Created by ZXL on 2019/7/12.
 *
 * 示例 :
 *  输入: 2
 *  输出: [0,1,3,2]，结果不唯一，长度为2^n，n为2时长度就为4
 *  解释:
 *      00 - 0
 *      01 - 1
 *      11 - 3
 *      10 - 2
 */
public class list05 {
    public static List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        // 初始化 n = 0 的解
        gray.add(0);
        for (int i = 0; i < n; i++) {
            // 要加的数，1左移i位
            int add = 1 << i;
            // 倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    public static void main(String[] args) {
        List<Integer> ans = grayCode(2);
        System.out.println(ans);
    }
}
