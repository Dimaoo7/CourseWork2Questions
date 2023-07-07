package pro.sky.coursework2questions.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2questions.exceptions.BAD_REQUEST;
import pro.sky.coursework2questions.interfaces.ExaminerService;
import pro.sky.coursework2questions.interfaces.QuestionService;
import pro.sky.coursework2questions.model.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public List<String> getQuestions(int amount) {//Тест к тому чтоб при максимальном значении вопросов
        // учитывалось что есть -1
        if (amount <= 0 || amount > service.getAll().size() -1) {
            throw new BAD_REQUEST();
        }
        Set<Question> tmp = new HashSet<>( List.of( service.getRandomQuestion()));
        while (tmp.size() < amount) {
            tmp.add(service.getRandomQuestion());
        }
        return tmp.stream().map(Question::getQuestion).collect(Collectors.toList());

    }
}
