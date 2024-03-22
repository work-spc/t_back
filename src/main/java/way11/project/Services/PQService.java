package way11.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import way11.project.Repositories.PQRepo;

@Service
public class PQService {

    @Autowired
    private PQRepo pqRepo;
}
