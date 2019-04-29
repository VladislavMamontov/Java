package Lesson_2;

public class Main {
    public static void main (String[] args){
        int n = 10000; //Количество чисел в списке
        int a = 0;     //Нижняя граница диапазона случайных чисел
        int b = 1000;  //Верхняя граница диапазона случайных чисел
        int m = 10;    //Количество экспериментов
        long [] selectionSortTime = new long[m]; //Массив для хранения времени сортировок выбором
        long [] insertionSortTime = new long[m]; //Массив для хранения времени сортировок вставками


        MyArrayList<Integer> list1 = new MyArrayList<>();
        MyArrayList<Integer> list2 = new MyArrayList<>();


        for (int i = 0; i < n; i++) {
            list1.add(a + (int)(Math.random()*b));
        }

        for (int i = 0; i < list1.size(); i++) {
            list2.add(list1.get(i));
        }

        for (int i = 0; i < m; i++) {
            long time = System.currentTimeMillis();
            list1.selectionSort(new Comparator());
            selectionSortTime[i] = System.currentTimeMillis() - time;
            for (int j = 0; j < list2.size(); j++) {
                list1.add(list2.get(i));
            }
        }
        long sumOfSelectionSortTime = 0;
        for (int i = 0; i < selectionSortTime.length; i++) {
            sumOfSelectionSortTime += selectionSortTime[i];
        }

        for (int i = 0; i < m; i++) {
            long time = System.currentTimeMillis();
            list1.insertionSort(new Comparator());
            insertionSortTime[i] = System.currentTimeMillis() - time;
            for (int j = 0; j < list2.size(); j++) {
                list1.add(list2.get(i));
            }
        }
        long sumOfInsertionSortTime = 0;
        for (int i = 0; i < insertionSortTime.length; i++) {
            sumOfInsertionSortTime += insertionSortTime[i];
        }



        System.out.println("№  " + "Insertion " + "Selection");
        for (int i = 0; i < m; i++) {
            System.out.println(i + 1 + "   " + insertionSortTime[i] + "      " + selectionSortTime[i]);
        }
        System.out.println("mid  " + sumOfInsertionSortTime/m + "     " + sumOfSelectionSortTime/m);



    }
}
