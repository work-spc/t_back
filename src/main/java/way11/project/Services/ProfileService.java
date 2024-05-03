package way11.project.Services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import way11.project.Entities.Profile;
import way11.project.Repositories.ProfileRepo;
import way11.project.Utils.ExcelExportUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static way11.project.Repositories.ProfileRepo.*;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    public Profile setProfile(Profile profile){
        return profileRepo.save(profile);
    }
    public Optional<Profile> findById(Integer id){
        return profileRepo.findById(id);
    }

    public List<Profile> downloadProfile(HttpServletResponse response) throws IOException {
        List<Profile> list = profileRepo.findAll();
        ExcelExportUtils exportUtils = new ExcelExportUtils(list);
        exportUtils.exportDataToExcel(response);
        return list;
    }
}
