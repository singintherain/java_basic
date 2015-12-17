/**
 * Created by lvsong on 7/6/15.
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;

        if(type.equals("cheese")) {
            pizza = new NYCheesePizza();
        } else if (type.equals("greek")) {
            pizza = new NYGreekPizza();
        } else if (type.equals("pep")) {
            pizza = new NYPepPizza();
        } else {
            pizza = new NYDefaultPizza();
        }

        return pizza;
    }
}
