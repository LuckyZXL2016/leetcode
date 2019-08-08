package examination.java;

/**
 * 二维数组中的查找在一个二维数组中（每个一维数组的长度相同），每一
 * 行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by ZXL on 2019/8/8.
 */
public class j_03_find_target {
    // 第一种
    public boolean Find(int target, int [][] array) {
        boolean flag = false;
        int row = array.length;
        int col = array[0].length;
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(array[i][j] == target) flag = true;
            }
        }
        return flag;
    }

    // 第二种
    public boolean Find2(int target, int [][] array) {
        boolean flag = false;
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                flag = true;
                break;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return flag;
    }
}
