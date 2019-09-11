package leetCode.test;

import java.util.Scanner;

/**
 * 参考 https://www.cnblogs.com/my-program-life/p/10987657.html
 * Created by ZXL on 2019/9/11.
 */
public class t03 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static void solution(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        //经过这个循环，把每行有值的格子，都被搬到最左边了，同一行右侧有值的格子，覆盖左侧值为0的格子
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] != 0) {
                    int tmp = nums[i][j];
                    int pre = j - 1;
                    while (pre >= 0 && nums[i][pre] == 0) {
                        nums[i][pre] = tmp;
                        nums[i][pre+1] = 0;
                        pre--;
                    }
                }
            }
        }
        //表盘当前左侧相邻相等的值会相加，造成左边值为【和】，相邻右边值为【0】
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j + 1 < col && (nums[i][j] == nums[i][j+1])
                    && (nums[i][j] != 0 || nums[i][j+1] != 0)) {
                    nums[i][j] = nums[i][j] + nums[i][j+1];
                    nums[i][j+1] = 0;
                }
            }
        }
        //经过这个循环，把每行有值的格子，都被搬到最左边了，同一行右侧有值的格子，覆盖左侧值为0的格子
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums[i][j] != 0) {
                    int tmp = nums[i][j];
                    int pre = j - 1;
                    while (pre >= 0 && nums[i][pre] == 0) {
                        nums[i][pre] = tmp;
                        nums[i][pre+1] = 0;
                        pre--;
                    }
                }
            }
        }

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        String[] input = new String[size];
        for (int i = 0; i < size; i++) {
            input[i] = in.nextLine();
        }
        int row = size;
        int col = input[0].split(" ").length;
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] res = input[i].split(" ");
            for (int j = 0; j < col; j++) {
                nums[i][j] = Integer.parseInt(res[j]);
            }
        }
        solution(nums);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}