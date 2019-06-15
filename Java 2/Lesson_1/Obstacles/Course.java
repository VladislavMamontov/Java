package Lesson_1.Obstacles;

import Lesson_1.Competitors.Team;
import Lesson_1.Competitors.Competitor;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }
    //Метод который просит команду пройти всю полосу
    public void go(Team team) {
        for (Competitor competitor : team.getCompetitors()) {
            for (Obstacle obstacle: obstacles) {
                obstacle.doIt(competitor);
                if (!competitor.isOnDistance())break;
            }
        }
    }
}
