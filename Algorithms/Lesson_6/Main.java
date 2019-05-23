package Lesson_6;


public class Main {
    public static void main(String[] args) {
//        // Проверка метода isBalanced
//        MyTreeMap<Character, Integer> map = new MyTreeMap<>();
//        map.put('S', 1);
//        map.put('E', 1);
//        map.put('A', 1);
//        map.put('C', 1);
//        map.put('X', 1);
//        map.put('Z', 1);
//        System.out.println(map.isBalanced());



        MyTreeMap<Integer, Integer>[] arrayOfTrees = initArrayOfTrees(20 , 6);
        int countOfUnbalanced = 0;
        for (int i = 0; i < arrayOfTrees.length; i++) {
            if (!arrayOfTrees[i].isBalanced()) countOfUnbalanced++;
        }

        System.out.println("Процент несбалансированных деревьев: " + (countOfUnbalanced * 1.0 / 20 * 1.0 * 100));

    }

    public static MyTreeMap<Integer, Integer>[] initArrayOfTrees(int size, int maxHeight)
    {
        MyTreeMap<Integer, Integer>[] arrayOfTrees = new MyTreeMap[size];
        for (int i = 0; i < size; i++) {
            arrayOfTrees[i] = new MyTreeMap<>();
            while (arrayOfTrees[i].height() < (int)(Math.random()*maxHeight)){
                arrayOfTrees[i].put((int)(Math.random()*1000) ,(-100 + (int)(Math.random()*200)) );
            }
        }
        return arrayOfTrees;
    }



}
