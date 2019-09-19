package leetCode.design.decorator;

/**
 *
 * Created by ZXL on 2019/9/19.
 */
public class ConcreteComponent implements Component {
    @Override
    public void function() {
        System.out.println("基础方法");
    }
}
