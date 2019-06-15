package Lesson_1.Competitors;

public class Team {
    private Competitor[] competitors = new Competitor[4];

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public Team(Competitor competitor1, Competitor competitor2, Competitor competitor3, Competitor competitor4) {
        competitors[0] = competitor1;
        competitors[1] = competitor2;
        competitors[2] = competitor3;
        competitors[3] = competitor4;
    }
    //Метод для вывода информации о членах команды прошедших дистанцию
    public void winners (){
        System.out.println("Члены команды прошедшие дистанцию:");
        for (Competitor competitor: competitors) {
            if (competitor.isOnDistance()) competitor.info();
        }
    }
    //Метод вывода информации обо всех членах команды
    public void showResults(){
        System.out.println("Результаты команды:");
        for (Competitor competitor: competitors) {
            competitor.info();
        }
    }
}
