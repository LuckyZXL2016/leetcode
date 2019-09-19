package leetCode.design.decorator;

/**
 *
 * Created by ZXL on 2019/9/19.
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void function() {
        super.function();
        decorator();
    }

    private void decorator() {
        System.out.println("装饰加的内容");
    }
}
