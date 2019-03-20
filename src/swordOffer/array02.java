package swordOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串
 * 为We%20Are%20Happy。
 * Created by ZXL on 2019/3/4.
 */
public class array02 {
    public static String replaceSpace(StringBuffer str) {
        int n = str.length();   // 字符串的长度
        int ii = 0; // 空格的个数ii
        for(int i = 0;i < n; i++) {
            // 检测空格
            if(str.charAt(i) == ' ') {
                ii++;
            }
        }
        int nn = 2 * ii + n;    // 根据空格的个数，得到新数组的长度
        int index = nn - 1;
        char[] ct = new char[nn];   // 新建数组
        while(n > 0) {
            if(str.charAt(n-1) != ' ') {
                // 如果不是空格
                ct[index--] = str.charAt(n-1);
            } else {
                // 如果是空格
                ct[index--] = '0';
                ct[index--] = '2';
                ct[index--] = '%';
            }
            // 取下一个字符
            n--;
        }
        return String.valueOf(ct);  // 将字符数组转为String类型后返回
    }

    public static void main(String args[]) {
        StringBuffer sbu = new StringBuffer("We Are Happy");
        String str = replaceSpace(sbu);
        System.out.println(str);
    }
}
