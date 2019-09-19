package leetCode.design.decorator;

/**
 * 装饰模式
 * Created by ZXL on 2019/9/19.
 */
public class Decorator implements Component {
    private Component component;
    Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void function() {
        component.function();
    }
}
