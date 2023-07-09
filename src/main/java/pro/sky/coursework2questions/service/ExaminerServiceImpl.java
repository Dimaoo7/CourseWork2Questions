package pro.sky.coursework2questions.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2questions.exceptions.AmountOutOfCollectionBoundException;
import pro.sky.coursework2questions.interfaces.ExaminerService;
import pro.sky.coursework2questions.interfaces.QuestionService;


import java.util.ArrayList;
import java.util.List;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<String> questionsList = new ArrayList<>();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<String> getQuestions(int amount) {
        questionsList.clear();
        validateQuantityQuestions(amount);
        int originalQuestionsCounter = 1;
        while (originalQuestionsCounter <= amount) {
            String question = questionService.getRandomQuestion().getQuestion();
            if (isQuestionUnique(question)) {
                questionsList.add(question);
                originalQuestionsCounter++;
            }
        }
        return questionsList;
    }

    private boolean isQuestionUnique(String question) {
        for (String element : questionsList) {
            if (element.equals(question)) {
                return false;
            }
        }
        return true;
    }

    private void validateQuantityQuestions(int amount) {
        if (amount < questionService.getAll().size() || amount > 0) {
            throw new AmountOutOfCollectionBoundException();
        }
    }
}
