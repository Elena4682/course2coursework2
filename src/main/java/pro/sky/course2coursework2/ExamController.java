package pro.sky.course2coursework2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService service;
    public ExamController(ExaminerService service){
        this.service = service;
    }
    @GetMapping("/get")
    public Collection<Question> getQuestions(@RequestParam int amount){
        return service.getQuestions(amount);
    }
}
