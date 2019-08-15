package examination.pufa;

/**
 * 喝饮料问题，一块钱一瓶饮料，两个空瓶子换一瓶饮料
 * 求4块钱能和多少饮料
 * Created by ZXL on 2019/8/15.
 */
public class p_21 {
    public static int drinkN(int money) {
        int num = 0;
        int kongping = 0;
        while (money > 0) {
            money--;
            num++;
            kongping++;
            if (kongping == 2) {
                num++;
                kongping = 0;
                kongping++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(drinkN(4));
    }
}
