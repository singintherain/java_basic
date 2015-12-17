package com.lvsong;

/**
 * Created by lvsong on 7/8/15.
 */
public class IncreaseImpl implements Increasable {
    private static final int max = 100000;

    private long count;

    public void increase(int delta) {
        count = 0;
        for(int i = 0; i < max; i++) {
            count += delta;
        }

        if (count % delta != 0) {
            throw new IllegalStateException("Count state is illegal");
        }

    }
}
