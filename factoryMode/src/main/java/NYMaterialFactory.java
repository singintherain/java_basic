import material.*;

/**
 * Created by lvsong on 7/6/15.
 */
public class NYMaterialFactory implements MaterialFactory {
    public Dough createDough() {
        return new NYDough();
    }

    public Clams createClams() {
        return new NYClams();
    }

    public Cheese createCheese() {
        return new NYCheese();
    }

    public Veggies createVeggies() {
        return new NYVeggies();
    }
}
