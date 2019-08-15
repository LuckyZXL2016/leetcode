package examination.pufa;

/**
 * 从求组中找出唯一出现一次得数
 * Created by ZXL on 2019/8/15.
 */
public class p_19 {
    public int unique(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
