import material.Cheese;
import material.Clams;
import material.Dough;
import material.Veggies;

/**
 * Created by lvsong on 7/6/15.
 */
public interface MaterialFactory {
    Dough createDough();
    Clams createClams();
    Cheese createCheese();
    Veggies createVeggies();
}
