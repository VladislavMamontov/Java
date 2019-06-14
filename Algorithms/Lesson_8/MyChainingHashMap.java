package Lesson_8;

public class MyChainingHashMap<Key, Value> {
    private int m = 7;
    private int size = 0;
    private Object[]st = new Object[m];

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node (Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private int hash (Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size (){return size;}

    public boolean isEmpty() { return size == 0; }

    public Value get (Key key){
        if (key == null){
            throw new IllegalArgumentException("Invalid key.");
        }
        int h = hash(key);
        Node currentNode = (Node) st[h];
        while (currentNode != null){
            if (key.equals(currentNode.key)) return currentNode.value;
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contains (Key key){
        return (get(key)!= null);
    }

    public void put (Key key, Value value){
        if (key == null){
            throw new IllegalArgumentException("Invalid key.");
        }
        int h = hash(key);
        Node currentNode = (Node)st[h];
        while (currentNode != null){
            if (key.equals(currentNode.key)){
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        st[h] = new Node(key, value, (Node) st[h]);
        size++;
    }
}
