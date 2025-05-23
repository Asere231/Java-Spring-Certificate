package QUIZ_CONSOLE_APP;

import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    String[] selection = new String[5];

    public QuestionService() {
        questions[0] = new Question(1, "What is the size of an int in Java?", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "What is the size of a double in Java?", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "What is the size of a char in Java?", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "What is the size of a long in Java?", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "What is the size of a boolean in Java?", "1", "2", "4", "8", "1");
    }

    public void playQuiz() {
        int i = 0;
        try (Scanner sc = new Scanner(System.in)) {
            for (Question q : questions) {
                System.out.println("--------------------------------------------------");
                System.out.println("Question " + q.getId() + ": " + q.getQuestion());
                System.out.println("A) " + q.getOpt1());
                System.out.println("B) " + q.getOpt2());
                System.out.println("C) " + q.getOpt3());
                System.out.println("D) " + q.getOpt4());
                System.out.print("Your answer: ");
                selection[i++] = sc.nextLine();
                System.out.println();
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Quiz complete. Your selections:");
        for (int j = 0; j < selection.length; j++) {
            System.out.println("Q" + (j + 1) + ": " + selection[j]);
        }
        System.out.println();
    }

    public void printScore() {
        int score = 0;
        int i = 0;

        for (Question q : questions) {
            if (q.getAnswer().equals(selection[i++])) {
                score++;
            }
        }

        System.out.println("Your score is: " + score + " out of " + questions.length);
    }
}
