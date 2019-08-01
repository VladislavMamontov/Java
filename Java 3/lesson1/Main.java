package lesson_1;



import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        swap(arr, 0, 4);
        System.out.println(Arrays.toString(arr));

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>(new Orange());
        Box<Apple> appleBox1 = new Box<>(new Apple());
        for (int i = 0; i < 5; i++) {
            orangeBox1.addFruit(new Orange());
            appleBox1.addFruit(new Apple());
        }
        System.out.println(orangeBox1.getWeight() + " " + orangeBox2.getWeight() + " " + appleBox1.getWeight());
        orangeBox1.pourTo(orangeBox2);
        System.out.println(orangeBox1.getWeight() + " " + orangeBox2.getWeight());
        System.out.println(orangeBox1.compare(new Box<Orange>()));
    }

    //method swapping array elements
    static <T> void swap(T[] arr, int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0 || ind1 > arr.length - 1 || ind2 > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        T temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    //method converting array to ArrayList
    static <T> ArrayList<T> arrayToArrayList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }
}


