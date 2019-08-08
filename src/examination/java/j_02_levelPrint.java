package examination.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * Created by ZXL on 2019/8/8.
 */
public class j_02_levelPrint {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if (pRoot == null) return out;

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> in = new ArrayList<>();
        queue.add(pRoot);
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            in.add(tmp.val);
            start++;
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);

            if (start == end) {
                out.add(in);
                start = 0;
                end = queue.size();
                in = new ArrayList<>();
            }
        }
        return out;
    }
}
