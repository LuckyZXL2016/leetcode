package examination.pufa;

import java.util.regex.Pattern;

/**
 * 统计汉字的个数
 * Created by ZXL on 2019/8/15.
 */
public class p_22 {

    public static void main(String[] args) {
        String text = "我饿产妇赛反倒三阿飞";
        System.out.println(counthanzi(text));

    }

    public static int counthanzi(String text) {
        int amount = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean matches = Pattern.matches("^[\u4E00-\u9Fa5]{0,}$", text.charAt(i) + "");
            if (matches) {
                amount++;
            }
        }
        return amount;
    }
}
