package lvsong.club;

/**
 * Created by lvsong on 11/4/15.
 */
public class GenericClass<T> {
    public T object;

    public GenericClass(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
