package Lesson_2;

public class Main {
    public static void main(String[] args) {
        String[][] strings = {
                {"1", "1", "1", "1"},
                {"1", "1", "qwerty", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println(sum(strings));
    }

    static int sum(String[][] array) {
        if (array.length != 4)
            throw new MyArraySizeException("Wrong array size", new IllegalArgumentException(), array);
        for (String[] s : array) {
            if (s.length != 4)
                throw new MyArraySizeException("Wrong array size", new IllegalArgumentException(), array);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    throw new MyArrayDataException("Exception in cell: [" + i + "] - [" + j + "]", "Wrong format");
                }
            }
        }
        return sum;
    }
}

