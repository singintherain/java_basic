import java.nio.channels.Selector;

/**
 * Created by lvsong on 11/28/15.
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object o) {
        items[next++] = o;
    }

    private class SequenceSelector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length ) i++; }
    }

    public SequenceSelector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(5);
        for( int i = 0; i < 5; i++) {
            sequence.add(Integer.toString(i));
        }

        SequenceSelector selector = sequence.selector();

        while(!selector.end()) {
            System.out.print(selector.current());
            selector.next();
        }
    }
}
