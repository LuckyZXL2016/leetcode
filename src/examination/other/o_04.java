package examination.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 滑动窗口中位数
 * Created by ZXL on 2019/8/23.
 */
public class o_04 {
    public static List<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> out = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = i; j < k + i; j++) {
                try {
                    list.add(nums[j]);
                } catch (Exception e) //捕获到异常说明剩余的数字不够k个
                {
                    break;
                }
            }
            if (list.size() == k)
                out.add(getMiddleNum(list));
            else
                break;
        }
        return out;
    }

    public static int getMiddleNum(List<Integer> list)//获取中位数
    {
        Collections.sort(list);
        if (list.size() % 2 != 0)
            return list.get(list.size() / 2);
        else
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 8, 5};
        System.out.println(medianSlidingWindow(nums, 3));
    }
}
