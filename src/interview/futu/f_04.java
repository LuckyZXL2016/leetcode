package interview.futu;

/**
 * java编写程序：求银行本息
 * Created by ZXL on 2019/9/24.
 */
public class f_04 {
    private double benxi;
    private double lilv;

    // 计算本息
    private double culBenxi(double money, int year) {
        benxi = money + money * getLilv(year) * year;
        return benxi;
    }

    private double getLilv(int year) {
        switch (year) {
            case 1:
                lilv = 2.25 / 100;
                break;
            case 2:
                lilv = 2.7 / 100;
                break;
            case 3:
                lilv = 3.24 / 100;
                break;
            case 4:
                lilv = 3.6 / 100;
                break;
            default:
                break;
        }
        return lilv;
    }

    public static void main(String[] args) {
        f_04 bx = new f_04();
        System.out.println("10000元存一年的本息为:"+bx.culBenxi(10000,1));
        System.out.println("10000元存两年的本息为:"+bx.culBenxi(10000,2));
        System.out.println("10000元存三年的本息为:"+bx.culBenxi(10000,3));
        System.out.println("10000元存四年的本息为:"+bx.culBenxi(10000,4));
    }
}
