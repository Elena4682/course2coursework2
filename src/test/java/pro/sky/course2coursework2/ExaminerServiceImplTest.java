package pro.sky.course2coursework2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {
    private  final Collection<Question> FULL_JAVA_SET = new HashSet<Question>();
    private static final Object FULL_EXAM_SET = new HashSet<>();

    @Mock
    JavaQuestionService service;
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(service);
    }
    @Test
    public void getQuestionsTest(){
        when(service.getAll()).thenReturn(FULL_JAVA_SET);
        when(examinerService.getAll()).thenReturn(FULL_EXAM_SET);
    }
    @Test
    public void getQuestionsExceptionTest(){
        assertThrows(NotEnoughQuestions.class,() -> examinerService.getQuestions(-1));
    }
    
}
