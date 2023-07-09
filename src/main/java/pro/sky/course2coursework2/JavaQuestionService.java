package pro.sky.course2coursework2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    private static final Set<Question> storage = new HashSet<>();
    private final Random random = new Random();

    public JavaQuestionService(ExaminerServiceImpl examinerService) {
    }

    @Override
    public Question add(String question,String answer){
        return add(new Question(question, answer));
    }
    @Override
    public Question add(Question question){
        storage.add(question);
        return question;
    }
    @Override
    public Question remove(Question question){
        if (storage.remove(question)){
            return question;
        }
        return null;
    }
    @Override
    public Collection<Question> getAll(){
        return new HashSet<>(storage);
    }
    @Override
    public Question getRandomQuestion(){
        var index = random.nextInt(storage.size());
        int i =0;
        for (Question question : storage){
            if (index == i){
                return question;
            }
            i++;
        }
        return null;
    }

}
