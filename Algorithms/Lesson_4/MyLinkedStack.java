package Lesson_4;

public class MyLinkedStack<Item> {
    MyLinkedList<Item> stack = new MyLinkedList<>();

    public void push(Item item){
        stack.addFirst(item);
    }
    public Item pop (){
        return stack.getFirst();
    }
    public int size(){
        return stack.size();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
