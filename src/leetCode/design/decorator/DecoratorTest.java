package leetCode.design.decorator;

/**
 *
 * Created by ZXL on 2019/9/19.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.function();
        System.out.println("####装饰后####");
        Decorator decorator = new ConcreteDecorator(component);
        decorator.function();
    }
}
