/**
 * Created by lvsong on 7/6/15.
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String pizzaType) {
        Pizza pizza;

        if(pizzaType.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (pizzaType.equals("greek")) {
            pizza = new GreekPizza();
        } else if (pizzaType.equals("pep")) {
            pizza = new PepPizza();
        } else {
            pizza = new DefaultPizza();
        }

        return pizza;
    }
}
