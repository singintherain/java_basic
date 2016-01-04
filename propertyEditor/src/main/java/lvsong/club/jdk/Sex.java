package lvsong.club.jdk;

/**
 * Created by lvsong on 1/3/16.
 */
public enum Sex {
    MALE(0), FEMAL(1);

    private int value;

    private Sex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
