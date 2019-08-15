package examination.pufa;

import java.util.Scanner;

/**
 * 给你年月日，求出是这年的第几天
 * Created by ZXL on 2019/8/15.
 */
public class p_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String date = sc.nextLine();
        // 2019-08-15
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int days = 0;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days += 30;
                    break;
                case 2:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        days += 29;
                    } else {
                        days += 28;
                    }
                    break;
            }
        }

        days += day;
        System.out.println(days);
    }
}
