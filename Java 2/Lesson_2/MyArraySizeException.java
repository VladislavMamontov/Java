package Lesson_2;

public class MyArraySizeException extends IllegalArgumentException {
    private String[][] strings;

    public String[][] getStrings(){
        return strings;
    }

    public MyArraySizeException(String message, Throwable cause, String[][] strings) {
        super(message, cause);
        this.strings = strings;
    }
}
