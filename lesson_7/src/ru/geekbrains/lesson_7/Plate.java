package ru.geekbrains.lesson_7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood () {
        return food;
    }

    public void setFood(int food){
        this.food = food;
    }

    public void decreaseFood (int n){
        if (food - n < 0) System.out.println("В тарелке недостаточно еды");
        else food -= n;
    }

    public void increaseFood (int n){
        food += n;
    }


}
