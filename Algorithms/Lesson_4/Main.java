package Lesson_4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<Character> list = new MyLinkedList<>();
        list.addFirst('a');
        list.addLast('b');
        list.addFirst('c');
        list.addLast('b');
        System.out.println(list);
        list.remove('b');
        System.out.println(list);
        System.out.println(list.indexOf('a'));
        list.removeLast();
        list.add(2,'h');
        list.add(2,'l');
        list.set(2,'q');
        list.set(3,'j');
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        Iterator<Character> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }
}
