package way11.project.Repositories;

import org.springframework.data.repository.CrudRepository;
import way11.project.Entities.Answer;

public interface AnswerRepo extends CrudRepository<Answer,Integer> {
    Answer findByAnswer(String answer);
    Answer findById(int id);
}
