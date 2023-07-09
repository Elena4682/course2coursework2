package pro.sky.course2coursework2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class JavaQuestionServiceTest {
    @Mock
    JavaQuestionService service;
    ExaminerServiceImpl examinerService;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        service = new JavaQuestionService(examinerService);
    }
    @Test
    void testAdd(){
        var questions = List.of(new Question("q1", "a1"),new Question("q2", "a2"));
        when(examinerService.getAll()).thenReturn(questions);

        var question = service.getRandomQuestion();
        Assertions.assertThat(questions).containsAnyOf(question);

        Set<Question> all = new HashSet<>();
        while (all.size()< questions.size()){
            all.add(service.getRandomQuestion());
        }
        Assertions.assertThat(all.size()).isEqualTo(questions.size());
        Assertions.assertThat(questions).containsExactlyInAnyOrderElementsOf(all);
    }
    @Test
    public void removeTest(){
        var expected = List.of(new Question("q1", "a1"));
        when(examinerService.getAll()).thenReturn(expected);
        var actual = List.of(new Question("q1", "a1"));
        assertEquals(expected,actual);
    }

    public void getAllTest(){
        service.getAll().clear();
        service.getAll().add(new Question("q1", "a1"));
        service.getAll().add(new Question("q2", "a2"));
        service.getAll().add(new Question("q3", "a3"));
        service.getAll().add(new Question("q4", "a4"));
        service.getAll().add(new Question("q5", "a5"));
        Collection<Question> expectedSet = service.getAll();
        assertTrue(expectedSet.containsAll(service.getAll()));
    }
}
