package pro.sky.coursework2questions.interfaces;

import pro.sky.coursework2questions.model.Question;

import java.util.Collection;

public interface QuestionService {

     Question getRandomQuestion();

     Question add(String question, String answer);

     void remove(String question, String answer);

     Collection<Question> getAll();


}
