package Lesson_1;

import Lesson_1.Competitors.*;
import Lesson_1.Obstacles.*;

public class Main {
    public static void main (String[] args){
//        Competitor[] competitors = {
//                new Human("Bob"),
//                new Cat("Pushok"),
//                new Dog("Tuzik")
//        };
//        Obstacle[] obstacles = {
//                new Water(10),
//                new Wall(2),
//                new Cross(100)
//        };
//        for (Competitor competitor: competitors) {
//            for (Obstacle o: obstacles) {
//                o.doIt(competitor);
//                if (!competitor.isOnDistance()) break;
//            }
//        }
//        for (Competitor competitor: competitors) {
//            competitor.info();
//        }

        Team team = new Team(
                new Cat("Pushok"),
                new Dog("Sharik"),
                new Human("Vova"),
                new Human("Pasha"));
        Course course = new Course(
                new Water(10),
                new Wall(1),
                new Cross(100));
         course.go(team);
         team.winners();
         team.showResults();
    }


}
