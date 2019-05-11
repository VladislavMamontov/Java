package Lesson_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(upendString());
        MyDeque<Character> deque = new MyDeque<>();
        deque.insertRight('d');
        deque.insertRight('e');
        deque.insertRight('f');
        System.out.println(deque);
        deque.insertLeft('c');
        deque.insertLeft('b');
        deque.insertLeft('a');
        System.out.println(deque);
        deque.removeRight();
        deque.removeLeft();
        System.out.println(deque);
        deque.removeRight();
        deque.removeRight();
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        deque.insertRight('d');
        deque.insertRight('e');
        deque.insertRight('f');
        System.out.println(deque);
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
    }


    private static String upendString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enterString = reader.readLine();
        MyArrayStack<Character> stack = new MyArrayStack<>();
        for (int i = 0; i < enterString.length(); i++) {
            stack.push(enterString.charAt(i));
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < enterString.length(); i++) {
            s.append(stack.pop());
        }
        return s.toString();
    }
}
