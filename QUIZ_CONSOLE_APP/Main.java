package QUIZ_CONSOLE_APP;

class Main {
    public static void main(String[] args) {
        QuestionService service = new QuestionService();
        service.playQuiz();
        service.printScore();
    }
}