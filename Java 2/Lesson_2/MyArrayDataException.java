package Lesson_2;

public class MyArrayDataException extends NumberFormatException{
    private String s;
    public String getS(){
        return s;
    }

    public MyArrayDataException(String s, String s1) {
        super(s);
        this.s = s1;
    }
}
