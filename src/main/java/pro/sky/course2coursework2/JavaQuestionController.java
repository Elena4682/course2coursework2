package pro.sky.course2coursework2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;
    public JavaQuestionController(QuestionService service){
        this.service = service;
    }
    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer){
        return service.add(question,answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer){
        return service.remove(new Question(question, answer));
    }
    @GetMapping
    public Collection<Question> getAll(){
        return service.getAll();
    }
}
