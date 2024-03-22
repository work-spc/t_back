package way11.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import way11.project.Entities.Question;
import way11.project.Repositories.QuestionRepo;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public Iterable<Question> findAll(){
        return questionRepo.findAll();
    }
}
