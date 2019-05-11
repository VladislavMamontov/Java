package Lesson_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>{
        Node cursor = first;
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = cursor.item;
            cursor = cursor.next;
            return item;
        }

    }
    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Node previous, Item item, Node next){
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public int size (){
        return size;
    }
    public boolean isEmpty (){
        return size == 0;
    }

    public Item getFirst (){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        return first.item;
    }

    public void addFirst(Item item){
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if (isEmpty()){
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }

    public Item removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        Node second = first.next;
        Item item = first.item;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()){
            last = null;
        } else {
            second.previous = null;
        }
        return item;
    }

    public Item getLast(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        return last.item;
    }

    public void addLast(Item item){
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        Node newLast = last.previous;
        Item item = last.item;
        last.previous = null;
        last = newLast;
        size--;
        if (isEmpty()){
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public Item get (int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        if (index < size/2){
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            return currentNode.item;
        } else {
            Node currentNode = last;
            int currentIndex = size - 1;
            while (currentIndex > index){
                currentNode = currentNode.previous;
                currentIndex--;
            }
            return currentNode.item;
        }

    }

    public void set (int index, Item item){
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        if (index < size / 2){
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.item = item;
        } else {
            Node currentNode = last;
            int currentIndex = size - 1;
            while (currentIndex > index){
                currentNode = currentNode.previous;
                currentIndex--;
            }
            currentNode.item = item;
        }

    }

    public int indexOf (Item item){
        Node currentNode = first;
        int currentIndex = 0;
        while (!currentNode.item.equals(item) && currentNode != null){
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode != null ? currentIndex : -1;
    }

    public boolean contains (Item item){
        return indexOf(item) > -1;
    }

    public Item remove (Item item){
        Node currentNode = first;
        while (currentNode != null && !currentNode.item.equals(item)){
            currentNode = currentNode.next;
        }
        if (currentNode == null){
            return null;
        }
        if (currentNode == first){
            return removeFirst();
        }
        if (currentNode == last){
            return removeLast();
        }

        Node next = currentNode.next;
        Node previous = currentNode.previous;
        next.previous = previous;
        previous.next = next;
        size--;
        currentNode.next = null;
        currentNode.previous = null;
        return currentNode.item;
    }

    public void add (int index, Item item){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            addFirst(item);
        } else if (index == size){
            addLast(item);
        } else {
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            Node previous = currentNode.previous;
            Node newNode = new Node(previous, item, currentNode);
            previous.next = newNode;
            currentNode.previous = newNode;
            size++;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            s.append(currentNode.item.toString());
            s.append(", ");
            currentNode = currentNode.next;
        }
        return s.toString();
    }

}
