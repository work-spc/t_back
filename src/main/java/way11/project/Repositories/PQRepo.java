package way11.project.Repositories;

import org.springframework.data.repository.CrudRepository;
import way11.project.Entities.ProfileAnswer;

public interface PQRepo extends CrudRepository<ProfileAnswer,Integer> {
}
