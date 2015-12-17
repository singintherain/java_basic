import material.Veggies;

/**
 * Created by lvsong on 7/6/15.
 */
public class NYCheesePizza extends Pizza {
    private MaterialFactory materialFactory;

    public NYCheesePizza(MaterialFactory materialFactory) {
        this.materialFactory = materialFactory;
    }

    @Override
    public void prepare() {
        dough = materialFactory.createDough();
        clams = materialFactory.createClams();
        cheese = materialFactory.createCheese();
        veggies = materialFactory.createVeggies();
    }
}
