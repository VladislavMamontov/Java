package Lesson_3;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private Object[] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize (int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(start+i) % queue.length];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    public void enqueue(Item item){
        if (size == queue.length){
            resize(queue.length * 2);
        }
        queue[end++] = item;
        end %= queue.length;
        size++;
    }
    public Item dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        start = (start + 1) / queue.length;
        size--;
        if (size == queue.length / 4 && size > 0){
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peekFront(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return (Item) queue[start];
    }

    public String toString (){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(queue[(start+i) % queue.length] + ", ");
        }
        return s.toString();
    }


}
