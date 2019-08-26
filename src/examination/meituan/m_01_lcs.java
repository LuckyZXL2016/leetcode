package examination.meituan;

/**
 * 最长公共字串
 * Created by ZXL on 2019/8/26.
 */
public class m_01_lcs {
    public static void main(String[] args) {
        String str1 = "abc123edf";
        String str2 = "bc123jg";
        String res = getLCS(str1, str2);
        System.out.println(res);
    }

    private static String getLCS(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[][] tmp = new int[arr1.length][arr2.length];
        int len = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr2.length; i++) {
            tmp[0][i] = (arr1[0] == arr2[i]) ? 1 : 0;
        }
        for (int j = 0; j < arr1.length; j++) {
            tmp[j][0] = (arr1[j] == arr2[0]) ? 1 : 0;
        }

        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    tmp[i][j] = tmp[i-1][j-1] + 1;
                    if (tmp[i][j] > len) {
                        len = tmp[i][j];
                        end = j;
                    }
                } else {
                    tmp[i][j] = 0;
                }
            }
        }

        start = end - len + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(arr2[i]);
        }

        return sb.toString();
    }
}
