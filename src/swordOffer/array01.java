package swordOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从
 * 左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组
 * 中是否含有该整数。
 * Created by ZXL on 2019/3/4.
 */
public class array01 {
    public static boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        if (row == 0 || col == 0)
            return false;
        if (target < array[0][0] || target > array[row - 1][col - 1])
            return false;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] array = {{15,18,20,22,32},{17,21,25,27,33},{19,24,34,35,66}};
        int target = 35;
        boolean bol = Find(target, array);
        System.out.print(bol);
    }
}

