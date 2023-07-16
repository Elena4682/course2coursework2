package pro.sky.course2coursework2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService){
        this.questionService = questionService;
    }
    public Collection<Question> getQuestions(int amount){
        var allQuestions = questionService.getAll();
        if (allQuestions.size()< amount){
            throw new NotEnoughQuestions();
        }
        if (allQuestions.size()== amount){
            return allQuestions;
        }
        var questions = new HashSet<Question>(amount);
        while (questions.size()< amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
