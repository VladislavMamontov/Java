package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

class Box<Item extends Fruit> {
    ArrayList<Item> box;

    public Box(Item... fruits) {
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    float getWeight(){
        if (box.size() == 0)return 0;
        return box.size() * box.get(0).getWeight();
    }

    boolean compare (Box<?> another){
        return Math.abs(this.getWeight() - another.getWeight()) < 0.001;
    }

    void pourTo (Box<Item> another){
        while (this.box.size() != 0){
            another.box.add(this.box.remove(0));
        }
    }

    void addFruit (Item item){
        box.add(item);
    }

}
