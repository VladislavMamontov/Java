package Lesson_1.Competitors;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) System.out.println(type + " " + name + " успешно пробежал");
        else {
            System.out.println(type + " " + name + " не смог пробежать");
            onDistance = false;
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) System.out.println(type + " " + name + " успешно проплыл");
        else{
            System.out.println(type + " " + name + " не смог проплыть");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) System.out.println(type + " " + name + " успешно прыгнул");
        else{
            System.out.println(type + " " + name + " не смог прыгнуть");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " " + onDistance);
    }
}
