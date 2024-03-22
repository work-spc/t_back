package way11.project.Repositories;


import org.springframework.data.repository.CrudRepository;
import way11.project.Entities.Profile;

public interface ProfileRepo extends CrudRepository<Profile,Integer> {
}
