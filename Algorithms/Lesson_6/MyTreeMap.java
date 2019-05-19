package Lesson_6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }
    private Node root = null;

    public boolean isEmpty (){return root == null;}

    public int size() {return size(root);}

    private int size(Node node){
        if (node == null)return 0;
        else return node.size;
    }
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if (node == null){
            return 0;
        }
        else return node.height;
    }

    public Value get (Key key){
        return get(key, root);
    }

    private Value get (Key key, Node node){
        if (key == null){
            throw new IllegalArgumentException("Wrong key");
        }
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0){
            return node.value;
        }
        if (cmp < 0){
            return get(key, node.left);
        } else {
            return get(key, node.right);
        }
    }

    public void put (Key key, Value value){
        root = put(key, value, root);
    }

    private Node put (Key key, Value value, Node node){
        if (key == null){
            throw new IllegalArgumentException();
        }
        if(node == null){
            return new Node(key, value, 1, 0);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0){
            node.value = value;
            return node;
        }
        if (cmp < 0){
            node.left = put(key, value, node.left);
        } else {
            node.right = put(key, value, node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        if (height(node.right) > height(node.left)){
            node.height = height(node.right) + 1;
        } else {
            node.height = height(node.left) + 1;
        }
        return node;
    }

    public Value min (){
        return min(root).value;
    }

    private Node min(Node node){
        if (node.left == null){
            return node;
        } else {
            return min(node.left);
        }
    }

    public Value max(){
        return max(root).value;
    }

    private Node max(Node node){
        if (node.right == null){
            return node;
        } else {
            return max(node.right);
        }
    }

    private Node removeMin (Node node){
        if (node.left == null){
            return node.right;
        }
        else {
            node.left = removeMin(node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;
        if (height(node.right) > height(node.left)){
            node.height = height(node.right) + 1;
        } else {
            node.height = height(node.left) + 1;
        }
        return node;
    }

    public void removeMin (){
        if (isEmpty()){
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeMin(root);
    }

    private Node removeMax (Node node){
        if (node.right == null){
            return node.left;
        } else {
            node.right = removeMax(node.right);
        }
        node.size = size(node.right) + size(node.left) + 1;
        if (height(node.right) > height(node.left)){
            node.height = height(node.right) + 1;
        } else {
            node.height = height(node.left) + 1;
        }
        return node;
    }
    public void removeMax (){
        if (isEmpty()){
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeMax(root);
    }

    public void remove (Key key){

    }

    private Node remove (Key key, Node node){
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0){
            if (node.left == null){
                return node.right;
            }
            if (node.right == null){
                return node.left;
            }
            Node tmp = node;
            node = max(node.left);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
            tmp = null;
        }
        else if (cmp < 0){
            node.left = remove(key, node.left);
        }
        else {
            node.right = remove(key, node.right);
        }
        node.size = size(node.right) + size(node.left) + 1;
        if (height(node.right) > height(node.left)){
            node.height = height(node.right) + 1;
        } else {
            node.height = height(node.left) + 1;
        }
        return node;
    }

    public boolean isBalanced (){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if (node == null) return true;
        if (height(node.left) - height(node.right) < -1 ||
                height(node.left) - height(node.right) > 1){
            return false;
        }
        if (node.left != null){
            if (!isBalanced(node.left)) return false;
        }
        if (node.right != null){
            if (!isBalanced(node.right)) return false;
        }
        return true;
    }

}
