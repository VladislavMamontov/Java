package Lesson_8;

public class MyLinearProbbingHashMap<Key, Value> {
    private int size = 0;
    private Object[] keys = new Object[1];
    private Object[] values = new Object[1];

    private int hash (Key key, int capacity){
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public int size (){return size;}

    public boolean isEmpty(){return size==0;}

    public Value get (Key key){
        if (key == null){
            throw new IllegalArgumentException("Invalid key.");
        }
        int h = hash(key, keys.length);
        for (int i = h; keys[i] != null; i=(i+1) % keys.length ){
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
        if (size == keys.length-1){
            resize();
        }
        int i;
        for (i = hash(key, keys.length); keys[i] != null; i = (i + 1) % keys.length) {
            if (( (Key) keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    private void resize (){
        Object[] newKeys = new Object[keys.length * 2];
        Object[] newValues = new Object[values.length * 2];
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null){
                newKeys[hash((Key) keys[i], newKeys.length)] = keys[i];
                newValues[hash((Key) keys[i], newKeys.length)] = values[i];
            }
        }
        keys = newKeys;
        values = newValues;
    }

}
