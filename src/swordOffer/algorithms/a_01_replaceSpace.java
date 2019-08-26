package swordOffer.algorithms;

/**
 * 替换空格
 * Created by ZXL on 2019/8/26.
 */
public class a_01_replaceSpace {
    public static void main(String[] args) {
        String str = "We Are Happy";
        String res = replaceSpace(str);
        System.out.println(res);
    }

    private static String replaceSpace(String str) {
        StringBuilder sb = new StringBuilder();
        String[] splits = str.split(" ");
        for (String s : splits) {
            sb.append(s);
            sb.append("%20");
        }
        return sb.substring(0,sb.length()-3);
    }
}
