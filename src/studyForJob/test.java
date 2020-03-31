package studyForJob;

import java.util.*;

/**
 * Created by ZXL on 2020/3/27.
 */
public class test {
    // 二叉树打印
    private void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    // 逐行打印
    private void bfs2(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int m = queue.size();
            while (m > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                m--;
            }
            System.out.println();
        }
    }

    // 打印第 k层节点
    private void bfs3(TreeNode root, int k) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        k = k - 1;
        while (!queue.isEmpty()) {
            int m = queue.size();

            if (k == 0) {
                while (m > 0) {
                    TreeNode node = queue.poll();
                    System.out.print(node.val + " ");
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    m--;
                }
            }

            while (m > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                m--;
            }
            k--;
        }
    }

    // 堆排序
    private static void adjustHeapSort(int[] arr, int i, int len) {
        int tmp = arr[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[i] < arr[k]) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = tmp;
    }

    // 选择排序
    private static void selectSort(int[] arr) {
        int len = arr.length;
        int minIndex;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i; j < len - 1; j++) {
                if (arr[minIndex] > arr[j+1]) {
                    minIndex = j+1;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    // 快速排序
    private void partition(int[] nums, int low, int high) {
        int index = getIndex(nums, low, high);
        if (index > low) {
            partition(nums, low, index-1);
        }
        if (index < high) {
            partition(nums, index+1,high);
        }
    }
    private int getIndex(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            while (low < high && nums[high] < tmp) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] > tmp) low++;
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }

    // 归并排序
    private void mergeSort(int[] nums, int low, int high) {
        int middle = (low + high) / 2;
        mergeSort(nums, low, middle);
        mergeSort(nums, middle+1, high);
        mergeArray(nums, low, middle, high);
    }
    private void mergeArray(int[] nums, int low, int middle, int high) {
        int p = low, q = middle + 1, start = low;
        int[] res = new int[nums.length];
        while (p <= middle && q <= high) {
            if (nums[p] < nums[q]) {
                res[start++] = nums[p++];
            } else {
                res[start++] = nums[q++];
            }
        }
        while (p <= middle) res[start++] = nums[p++];
        while (q <= high) res[start++] = nums[q++];
        for (int i = low; i <= high; i++) {
            nums[i] = res[i];
        }
    }


    // 树的遍历-递归
    private void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    // 树的遍历-非递归
    private void preOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }
    private void inOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tCur = root;
        while (tCur != null || !stack.isEmpty()) {
            while (tCur != null) {
                stack.push(tCur);
                tCur = tCur.left;
            }
            TreeNode node = stack.pop();
            System.out.println(node.val);
            tCur = node.right;
        }
    }
    private void postOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tCur = root;
        TreeNode tPre = root;
        while (tCur != null || !stack.isEmpty()) {
            while (tCur != null) {
                stack.push(tCur);
                tCur = tCur.left;
            }
            TreeNode t = stack.peek().right;
            if (t == null || t == tPre) {
                tCur = stack.pop();
                System.out.println(tCur.val);
                tPre = tCur;
                tCur = null;
            } else {
                tCur = t;
            }
        }
    }

    // 单链表每k个元素倒序
    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                pre = reverse(pre,next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode pre, ListNode end) {
        if (pre == null || end == null) return null;
        ListNode head = pre.next;
        ListNode cur = pre.next.next;

        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }

    // 最长回文子串
    private String longestPalindrome(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];
        int start = 0, max = 0;

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        start = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str.substring(start, start + max);
    }

    // 最长回文子序列
    private int longestPalindrome2(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }

    // 最长公共子序列
    private int longestPalindrome3(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    // 最长公共子串
    private String longestPalindrome4(String str1, String str2) {
        if (str1 == null || str2 == null) return null;
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        int maxLen = 0, maxEnd = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        maxEnd = i;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        int start = maxEnd - maxLen;
        return str1.substring(start, maxLen);
    }

    // 逆序数个数
    private int inversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int count = getCount(nums, 0, len-1);
        return count;
    }
    private int getCount(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        int leftCount = getCount(nums, start, middle);
        int rightCount = getCount(nums, middle, end);

        int count = 0;
        int[] tmp = new int[nums.length];
        int p = middle, q = end, k = end;
        while (p >= start && q >= middle + 1) {
            if (nums[p] > nums[q]) {
                count = count + (q - p);
                tmp[k--] = nums[p--];
            } else {
                tmp[k--] = nums[q--];
            }
        }
        while (p >= start) tmp[k--] = nums[p--];
        while (q >= middle + 1) tmp[k--] = nums[q--];

        for (int i = start; i <= end; i++) {
            nums[i] = tmp[i];
        }
        return count + leftCount + rightCount;
    }

    // 最长上升子序列
    private int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 递归求树的深度
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i))
                return i;
        }
        return len+1;
    }

    public static void main(String[] args) {
        // 堆排序
        int[] arr = {1,2,3,4,5,6};
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeapSort(arr, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            // swap(arr, 0, i)
            adjustHeapSort(arr, 0, i);
        }


    }
}
class Lru extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    Lru(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/* class Lru2 {
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;

    Lru2(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    private void addToHead(DLinkedNode node) {
        head.next = node;
        node.pre = head;
        node.next = tail;
        tail.pre = node;
    }
    private void deleteNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void moveToHead(DLinkedNode node) {
        deleteNode(node);
        addToHead(node);
    }
    private DLinkedNode popTail() {
        DLinkedNode node = tail.pre;
        deleteNode(node);
        return node;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            return node.value;
        }
    }
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            moveToHead(node);
            size++;
            if (size > capacity) {
                DLinkedNode n = popTail();
                cache.remove(n.key);
                size--;
            }
        }
    }
}
*/
class StackToQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    private int size() {
        return s1.size() + s2.size();
    }
    private void s1ToS2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
    public void push(Integer x) {
        s1.push(x);
    }
    public int pop() {
        if (size() > 0) {
            if (!s2.isEmpty()) {
                return s2.pop();
            } else {
                s1ToS2();
                return s2.pop();
            }
        } else {
            return -1;
        }
    }
}

class QueueToStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    private int size() {
        return q1.size() + q2.size();
    }
    private void putN_1ToAnother() {
        if (!q1.isEmpty()) {
            while (q1.size() > 0) {
                q2.add(q1.poll());
            }
        } else {
            while (q2.size() > 0) {
                q1.add(q2.poll());
            }
        }
    }
    public void push(Integer x) {
        q1.add(x);
    }
    public int get() {
        if (size() > 0) {
            if (!q1.isEmpty()) {
                putN_1ToAnother();
                return q1.poll();
            } else {
                putN_1ToAnother();
                return q2.poll();
            }
        } else {
            return -1;
        }
    }
}
