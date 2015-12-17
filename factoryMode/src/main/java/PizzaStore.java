/**
 * Created by lvsong on 7/6/15.
 */
public abstract class PizzaStore {
//    SimplePizzaFactory pizzaFactory = new SimplePizzaFactory();
//
//    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
//        this.pizzaFactory = pizzaFactory;
//    }

    public Pizza orderPizza(String pizzaType) {
//        Pizza pizza = new Pizza();
//        Pizza pizza;
//
//        if(pizzaType.equals("cheese")) {
//            pizza = new CheesePizza();
//        } else if (pizzaType.equals("greek")) {
//            pizza = new GreekPizza();
//        } else if (pizzaType.equals("pep")) {
//            pizza = new PepPizza();
//        } else {
//            pizza = new DefaultPizza();
//        }
        // 简单工厂
//        Pizza pizza = new SimplePizzaFactory().createPizza(pizzaType);

        //
        Pizza pizza = createPizza(pizzaType);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
