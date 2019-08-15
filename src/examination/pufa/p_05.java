package examination.pufa;

/**
 * 判断从1990到2010年中的润年？并打印
 * Created by ZXL on 2019/8/15.
 */
public class p_05 {
    public static void main(String[] args) {
        for (int i = 1990; i <= 2010; i++) {
            if (i % 100 != 0 && i % 4 == 0 || i % 400 == 0) {
                System.out.println(i);
            }
        }
    }
}
