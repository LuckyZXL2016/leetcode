package examination.huawei;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 有两个文件a.txt和b.txt，编程实现将两个文件中的各个单词，交替写到另一个c.txt文件中
 * Created by ZXL on 2019/4/10.
 */
// 文件读取写入辅助类
class FileManager {
    String[] words = null;
    int pos = 0;    // words的索引

    // 读入文件信息，根据分隔符，存入字符串数组words中
    public FileManager(String filename, char[] seperators) throws Exception {
        File f = new File(filename);
        FileReader reader = new FileReader(filename);   // 文件字符流
        char[] buf = new char[(int)f.length()]; // f和文件字符流一样大
        int len = reader.read(buf); // 读取的长度--小文件，一次性读取
        String results = new String(buf, 0, len);
        String regex = null;    // 正则表达式
        if (seperators.length > 1) {
            regex = "" + seperators[0] + "|" + seperators[1];
        } else {
            regex = "" + seperators[0];
        }
        words = results.split(regex);
        reader.close();
    }

    // 返回当前pos位置的words[pos]，然后后移pos，即pos++
    public String nextWord() {
        if (pos == words.length) {
            return null;
        }
        return words[pos++];
    }
}

public class h_01 {
    public static void main(String[] args) throws Exception {
        FileWriter ra = new FileWriter("./a.txt");    // 字符流
        ra.write("adsf\nasgdg\ndasg\nqewr\ntrt\n");
        ra.close();

        FileWriter rb = new FileWriter("./b.txt");
        rb.write("adsf asgdg dasg\nqewr trt\n");
        rb.close();

        FileManager a = new FileManager("./a.txt", new char[]{'\n'});
        FileManager b = new FileManager("./b.txt", new char[]{'\n', ' '});
        FileWriter c = new FileWriter("./c.txt");
        String aWord = null;
        String bWord = null;

        // 交替写入
        while ((aWord = a.nextWord()) != null) {
            c.write(aWord + "\n");
            bWord = b.nextWord();
            if (bWord != null) {
                c.write(bWord + "\n");
            }
        }
        // 如果b还有
        while ((bWord = b.nextWord()) != null) {
            c.write(bWord + "\n");
        }
        c.close();
    }
}
