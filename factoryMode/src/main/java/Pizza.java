import material.Cheese;
import material.Clams;
import material.Dough;
import material.Veggies;

/**
 * Created by lvsong on 7/6/15.
 */
public abstract class Pizza {
    Dough dough;
    Clams clams;
    Veggies veggies;
    Cheese cheese;

    abstract public void prepare();

    public void bake() {

    }

    public void cut() {

    }

    public void box() {

    }
}
