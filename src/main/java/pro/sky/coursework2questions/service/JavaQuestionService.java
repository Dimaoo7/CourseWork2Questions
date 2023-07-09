package pro.sky.coursework2questions.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2questions.interfaces.QuestionService;
import pro.sky.coursework2questions.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>(List.of(
            new Question("Question 1", "Answer 1"),
            new Question("Question 2", "Answer 2"),
            new Question("Question 3", "Answer 3"),
            new Question("Question 4", "Answer 4"),
            new Question("Question 5", "Answer 5"),
            new Question("Question 6", "Answer 6"),
            new Question("Question 7", "Answer 7"),
            new Question("Question 8", "Answer 8"),
            new Question("Question 9", "Answer 9"),
            new Question("Question 10", "Answer 10")
    ));

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int size = questions.size();
        int item = new Random().nextInt(size);
        int i = 0;
        Question rez = null;
        for (Question element : questions) {
            if (i == item) {
                rez = element;
            }
            i++;
        }
        return rez;

    }

    @Override
    public void add(String question, String answer) {
        questions.add(new Question(question, answer));
        System.out.println("объект Question добавлен\n" +
                question + "\n" +
                answer + "\n");
    }

    @Override
    public void remove(String question, String answer) {
        Question questionNeedRemove = new Question(question, answer);
        questions.remove(questionNeedRemove);
        System.out.println("объект Question удален\n" +
                question + "\n" +
                answer + "\n");
    }

    @Override
    public Set<Question> getAll() {
        for(Question question: questions){
            System.out.println(question);
        }
        return questions;
    }
}
