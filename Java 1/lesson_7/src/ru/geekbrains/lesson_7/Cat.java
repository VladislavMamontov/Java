package ru.geekbrains.lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat (Plate p){
        if (p.getFood() >= appetite ) this.satiety = true;
        p.decreaseFood(appetite);

    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean getSatiety (){
        return satiety;
    }

    public void checkSatiety (){
        if (satiety) System.out.println(name + " сыт");
        else System.out.println(name + " голоден");
    }


}
