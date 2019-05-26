package Lesson_8;

public class MyLinearProbbingHashMap<Key, Value> {
    private int m = 91;
    private int size = 0;
    private Object[] keys = new Object[m];
    private Object[] values = new Object[m];

    private int hash (Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size (){return size;}

    public boolean isEmpty(){return size==0;}

    public Value get (Key key){
        if (key == null){
            throw new IllegalArgumentException("Invalid key.");
        }
        int h = hash(key);
        for (int i = h; keys[i] != null; i=(i+1) % m ){
            if (keys[i].equals(key)) return (Value)values[i];
        }
        return null;
    }

    public boolean contains (Key key){
        return get(key)!=null;
    }

    public void put (Key key, Value value){
        if (key == null){
            throw new IllegalArgumentException("Invalid key.");
        }
        if (size == m-1){
            throw new IndexOutOfBoundsException("Maximum key-value count.");
        }
        int i;
        for (i = hash(key); key != null; i = (i + 1) % m) {
            if (( (Key) keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;

    }

}
