package Lesson_3;

import java.util.NoSuchElementException;

public class MyDeque<Item> {
    private Object[] dequeRight = new Object[1];
    private Object[] dequeLeft = new Object[1];

    private int sizeRight = 0;
    private int sizeLeft = 0;
    private int right = 0;
    private int left = 0;


    public int size (){
        return sizeRight + sizeLeft;
    }

    public boolean isEmpty(int size){
        return size == 0;
    }

    private void resizeRight (int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < sizeRight; i++) {
            temp[i] = dequeRight[(left+i) % dequeRight.length];
        }
        dequeRight = temp;
        left = 0;
    }

    private void resizeLeft (int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < sizeLeft; i++) {
            temp[i] = dequeLeft[(right + i) % dequeLeft.length];
        }
        dequeLeft = temp;
        right = 0;
    }

    public void insertRight (Item item){
        if (sizeRight == dequeRight.length){
            resizeRight(dequeRight.length * 2);
        }
        dequeRight[(left + sizeRight) % dequeRight.length] = item;
        sizeRight++;
    }

    public void insertLeft (Item item){
        if (sizeLeft==dequeLeft.length){
            resizeLeft(2*dequeLeft.length);
        }
        dequeLeft[(right + sizeLeft) % dequeLeft.length] = item;
        sizeLeft++;
    }

    public Item removeRight (){
        if (isEmpty(sizeRight)){
            if (isEmpty(sizeLeft)){
                throw new NoSuchElementException("Deque is empty");
            }else {
                Item item = (Item)dequeLeft[right];
                dequeLeft[right] = null;
                right = (right + 1)%dequeLeft.length;
                sizeLeft--;
                return item;
            }
        }
        Item item = (Item) dequeRight[sizeRight -1];
        dequeRight[sizeRight - 1] = null;
        sizeRight--;
        if (sizeRight == dequeRight.length / 4 && sizeRight > 0){
            resizeRight(dequeRight.length / 2);
        }
        return item;
    }

    public Item removeLeft(){
        if (isEmpty(sizeLeft)){
            if (isEmpty(sizeRight)){
                throw new NoSuchElementException("Deque is empty");
            }else{
                Item item = (Item)dequeRight[left];
                dequeRight[left] = null;
                left = (left + 1) % dequeRight.length;
                sizeRight--;
                return item;
            }
        }
        Item item = (Item) dequeLeft[sizeLeft - 1];
        dequeLeft[sizeLeft - 1] = null;
        sizeLeft--;
        if (sizeLeft == dequeLeft.length / 4 && sizeLeft > 0){
            resizeLeft(dequeLeft.length / 2);
        }
        return item;
    }

    public Item peekRight(){
        if (isEmpty(sizeRight)){
            if ((isEmpty(sizeLeft))){
                throw new NoSuchElementException("Deque is empty");
            }else {
                return (Item)dequeLeft[right];
            }
        }
        return (Item) dequeRight[(left + sizeRight-1) % dequeRight.length];
    }
    public Item peekLeft(){
        if (isEmpty(sizeLeft)){
            if (isEmpty(sizeRight)){
                throw new NoSuchElementException("Deque is empty");
            } else {
                return (Item) dequeRight[left];
            }
        }
        return (Item) dequeLeft[(right + sizeLeft - 1) % dequeLeft.length];
    }

    public String toString (){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sizeLeft; i++) {
            s.append(dequeLeft[(right + sizeLeft -1 - i) % dequeLeft.length] + ", ");
        }
        for (int i = 0; i < sizeRight; i++) {
            s.append(dequeRight[(left + i) % dequeRight.length] + ", ");
        }
        return s.toString();
    }
}

//   l
// 0 1 2 3
//   e f
// r
// 0 1 2 3  =  3 2 1 0
// c b a    =  a b c