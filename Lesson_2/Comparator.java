package Lesson_2;

public class Comparator implements java.util.Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
