package studyForJob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 滑动窗口中位数
 * Created by ZXL on 2019/8/30.
 */
public class s_26 {
    public static List<Integer> getMedianSlidingWindow(int[] nums, int k) {
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> ls = new ArrayList<>();
            for (int j = i; j < i+k; j++) {
                ls.add(nums[j]);
            }
            if (ls.size() == k) out.add(getMiddle(ls));
        }
        return out;
    }

    private static int getMiddle(List<Integer> ls) {
        Collections.sort(ls);
        if (ls.size() % 2 == 0) {
            return ls.get(ls.size() / 2);
        } else {
            return (ls.get(ls.size() / 2) + ls.get(ls.size() / 2 - 1)) / 2;
        }
    }
}
