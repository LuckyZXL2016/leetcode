package examination.pufa;

/**
 * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个，第二天早上又
 * 将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 * Created by ZXL on 2019/8/15.
 */
public class p_09 {
    public static void main(String[] args) {
        int peach = 1;

        for (int i = 0; i < 9; i++) {
            peach = (peach + 1) * 2;
        }

        System.out.println(peach);
    }
}
