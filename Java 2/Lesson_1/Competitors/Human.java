package Lesson_1.Competitors;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;

    boolean active;

    public Human(String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.active = true;
    }

    public Human(String name) {
        this(name, 400, 15, 1);
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) System.out.println(name + " успешно пробежал");
        else {
            System.out.println(name + " не смог пробежать");
            active = false;
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) System.out.println(name + " успешно проплыл");
        else{
            System.out.println(name + " не смог проплыть");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) System.out.println(name + " успешно прыгнул");
        else{
            System.out.println(name + " не смог прыгнуть");
            active = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name + " " + active);
    }
}
