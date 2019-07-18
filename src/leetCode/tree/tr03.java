package leetCode.tree;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * Created by ZXL on 2019/7/18.
 *
 * 示例 :
 *  输入: root = [3,1,4,null,2], k = 1
 *      3
 *     / \
 *    1   4
 *     \
 *      2
 *  输出: 1
 */
public class tr03 {

    private int count = 0;
    private int res = 0;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        count--;
        if (count == 0) {
            this.res = node.val;
        }
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }
}
