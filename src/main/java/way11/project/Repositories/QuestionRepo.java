package way11.project.Repositories;

import org.springframework.data.repository.CrudRepository;
import way11.project.Entities.Answer;
import way11.project.Entities.Question;

public interface QuestionRepo extends CrudRepository<Question,Integer> {

    Question findByQuestion(String question);
    Question findById(int id);
}
