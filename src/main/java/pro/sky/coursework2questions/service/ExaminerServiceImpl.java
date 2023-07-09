package pro.sky.coursework2questions.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2questions.exceptions.AmountOutOfCollectionBoundException;
import pro.sky.coursework2questions.interfaces.ExaminerService;
import pro.sky.coursework2questions.interfaces.QuestionService;


import java.util.ArrayList;
import java.util.List;


@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<String> getQuestions(int amount) {
        List<String> questionsList = new ArrayList<>();
        validateQuantityQuestions(amount);
        if (questionsList.toString().contains(questionService.getRandomQuestion().getQuestion())) {
            questionsList.add(questionService.getRandomQuestion().getQuestion());
        }
        return questionsList;
    }

    private void validateQuantityQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount < 0) {
            throw new AmountOutOfCollectionBoundException();
        }
    }
}
