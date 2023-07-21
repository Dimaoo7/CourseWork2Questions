package pro.sky.coursework2questions.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pro.sky.coursework2questions.model.Question;
import pro.sky.coursework2questions.service.ExaminerServiceImpl;
import pro.sky.coursework2questions.service.JavaQuestionService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExaminerServiceTest {

    private ExaminerService exService;

    @Mock
    private JavaQuestionService service;

    @BeforeEach
    public void setUp(){
        service = new JavaQuestionService();
        exService = new ExaminerServiceImpl(service);
    }

    @Test
    public void getQuestionsTest() {
        List<String> expectedQuestionList = exService.getQuestions(4);

        for (String s : expectedQuestionList) {
            for (Question element : service.getAll()) {
                if (s.equals(element.getQuestion())) {
                    String expectedQuestion = element.getQuestion();
                    assertEquals(expectedQuestion, s);
                }
            }
        }
        Set<String> expectedQuestionSet = new HashSet<>(expectedQuestionList);
        assertEquals(expectedQuestionList.size(), expectedQuestionSet.size());
    }

    @Test
    public void getQuestionExceptionTest(){
        assertThrows(RuntimeException.class, () -> exService.getQuestions(service.getAll().size() + 1));
        assertThrows(RuntimeException.class, () -> exService.getQuestions(-1));

    }


}
