package leetCode.dp;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * Created by ZXL on 2019/3/11.
 * <p>
 * 输入: 3
 * 输出: 5
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        val = x;
    }
}

public class dp08 {
    // 参考 https://blog.csdn.net/u014472643/article/details/81260183
    private static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    private static List<TreeNode> getSubTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTrees = getSubTrees(start, i - 1);
            List<TreeNode> subRightTrees = getSubTrees(i + 1, end);
            for (TreeNode left : subLeftTrees) {
                for (TreeNode right : subRightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(numTrees(n));
        System.out.println(getSubTrees(1, n).size());
    }
}
