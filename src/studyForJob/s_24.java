package studyForJob;

import java.util.ArrayList;
import java.util.List;

/**
 * 给个字符串，求出得到的所有有效ip
 * 255255255255 ==> 255.255.255.255
 * Created by ZXL on 2019/8/30.
 */
public class s_24 {
    private List<String> getIpAddress(String str) {
        List<String> res = new ArrayList<>();

        if (str == null || str.length() < 4) return res;

        for (int i = 1; i < 4 && i < str.length() - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < str.length() - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < str.length(); k++) {
                    if (str.length() - k > 4)
                        continue;
                    ;
                    int a = Integer.parseInt(str.substring(0, i));
                    int b = Integer.parseInt(str.substring(i, j));
                    int c = Integer.parseInt(str.substring(j, k));
                    int d = Integer.parseInt(str.substring(k));

                    String ip = a + "," + b + "," + c + "," + d;
                    if (ip.length() < str.length() + 3)
                        continue;
                    res.add(ip);
                }
            }
        }
        return res;
    }
}
