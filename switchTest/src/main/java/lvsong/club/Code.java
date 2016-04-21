package lvsong.club;

/**
 * Created by lvsong on 4/15/16.
 */
public enum Code implements CodeDeperated {
    OK(Ok), SYSTEMERROR(SystemError);

    private int value;

    private Code(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
