package pro.sky.coursework2questions.interfaces;

import pro.sky.coursework2questions.model.Question;

import java.util.Set;

public interface QuestionService {

     void add(String question, String answer);

     void remove(String question, String answer);

     Set<Question> getAll();

     Question getRandomQuestion();


}
