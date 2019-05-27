package Lesson_8;


public class Main {
    public static void main(String[] args) {

//        MyChainingHashMap<Character, Integer> map = new MyChainingHashMap<>();
//        map.put('h', 100);
//        map.put('g', 34);
//        map.put('k', 456);
//        map.put('o', 75);
//        map.put('e', 75);
//        map.put('b', 457);
//        map.put('p', 345);
//        map.put('l', 97);
//        System.out.println(map.get('b'));
//        System.out.println(map.get('k'));
//        System.out.println(map.get('l'));
//        System.out.println(map.size());
//        System.out.println(map.contains('h'));
//        System.out.println(map.contains('p'));
//        System.out.println(map.contains('x'));
        MyLinearProbbingHashMap<Character, Integer> map = new MyLinearProbbingHashMap<>();
        map.put('h', 100);
        map.put('g', 34);
        map.put('k', 456);
        map.put('o', 75);
        map.put('e', 75);
        map.put('b', 457);
        map.put('p', 345);
        map.put('l', 97);
        System.out.println(map.size());
        System.out.println(map.get('h'));
        System.out.println(map.get('g'));
        System.out.println(map.get('k'));
        System.out.println(map.get('o'));
        System.out.println(map.get('e'));
        System.out.println(map.get('b'));
        System.out.println(map.get('p'));
        System.out.println(map.get('l'));



    }
}
