package pro.sky.coursework2questions.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.coursework2questions.model.Question;
import pro.sky.coursework2questions.service.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.coursework2questions.TestConstants.*;

class QuestionServiceTest {

    private final JavaQuestionService service = new JavaQuestionService();

    @BeforeEach
    public void setUp() {
        service.getAll().clear();
        assertTrue(service.getAll().isEmpty());
    }

    public static Stream<Arguments> provideParamsForTheTests() {
        return Stream.of(
                Arguments.of( QUESTION1 ),
                Arguments.of( QUESTION2 ),
                Arguments.of( QUESTION3 ),
                Arguments.of( QUESTION4 ),
                Arguments.of( QUESTION5 )
        );
    }

    private void fullCollectionWithTestQuestions() {
        service.getAll().add( QUESTION1 );
        service.getAll().add( QUESTION2 );
        service.getAll().add( QUESTION3 );
        service.getAll().add( QUESTION4 );
        service.getAll().add( QUESTION5 );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void addParametrisedTest(Question question) {
        fullCollectionWithTestQuestions();
        assertTrue(service.getAll().contains(question));
    }

    @Test
    void add() {
        fullCollectionWithTestQuestions();

        assertTrue(service.getAll().contains( QUESTION1 ));
        assertTrue(service.getAll().contains( QUESTION2 ));
        assertTrue(service.getAll().contains( QUESTION3 ));
        assertTrue(service.getAll().contains( QUESTION4 ));
        assertTrue(service.getAll().contains( QUESTION5 ));
    }

    @Test
    void remove() {
        String question = QUESTION1.getQuestion();
        String answer = QUESTION1.getAnswer();

        service.add(question, answer);
        assertTrue(service.getAll().contains(QUESTION1));

        service.remove(QUESTION1.getQuestion(), QUESTION1.getAnswer());
        assertFalse(service.getAll().contains(QUESTION1));
    }

    @Test
    void getAll() {
        fullCollectionWithTestQuestions();

        Set<Question> expectedSet = new HashSet<>();
        expectedSet.add(new Question(QUESTION1.getQuestion(), QUESTION1.getAnswer()));
        expectedSet.add(new Question(QUESTION2.getQuestion(), QUESTION2.getAnswer()));
        expectedSet.add(new Question(QUESTION3.getQuestion(), QUESTION3.getAnswer()));
        expectedSet.add(new Question(QUESTION4.getQuestion(), QUESTION4.getAnswer()));
        expectedSet.add(new Question(QUESTION5.getQuestion(), QUESTION5.getAnswer()));

        assertNotNull(service.getAll());
        assertEquals(expectedSet, service.getAll());

    }

    @Test
    public void getRandomQuestion() {
        assertThrows(RuntimeException.class, service::getRandomQuestion);
    }
}
