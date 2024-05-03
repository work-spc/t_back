package way11.project.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import way11.project.Entities.Answer;
import way11.project.Entities.Profile;
import way11.project.Entities.Question;
import way11.project.Repositories.QuestionRepo;
import way11.project.Services.CommonService;
import way11.project.Services.ProfileService;
import way11.project.dtos.AnswerDTO;
import way11.project.dtos.CommonDTO;

import java.io.IOException;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private CommonService commonService;

//    @PostMapping("/profile/set")
//    public ResponseEntity setProfile(@RequestBody Profile profile){
//        profileService.setProfile(profile);
//      return ResponseEntity.ok("ok");
//    }
    @CrossOrigin
    @GetMapping("/test/showall")
    public ResponseEntity showTest(){
        return ResponseEntity.ok(questionRepo.findAll());
    }
    // Записать результаты теста

//    @PostMapping("/test/set")
//    public ResponseEntity setTest(CommonDTO request){
//
//    }
    @GetMapping("/profile/show")
    public ResponseEntity showProfile(@RequestParam Integer id){
        return ResponseEntity.ok(profileService.findById(id));
    }

    @PostMapping("/profile/set")
    public ResponseEntity getBody(@RequestBody Profile profile){
        profileService.setProfile(profile);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/answer/set")
    public ResponseEntity setAnswers(@RequestBody List<Answer> answers){
        return ResponseEntity.ok(commonService.setAnswers(answers));
    }

    @PostMapping("/question/set")
    public ResponseEntity setQuestion(@RequestBody Question question){
        try {
            return ResponseEntity.ok(commonService.setQuestion(question));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }

    }
    @CrossOrigin
    @PostMapping("/questions/set")
    public ResponseEntity setQuestions(@RequestBody List<Question> questions){
        try {
            return ResponseEntity.ok(commonService.setQuestions(questions));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }

    }
    @CrossOrigin
    @PostMapping("/profile/save")
    public ResponseEntity saveProfile(@RequestBody CommonDTO body){
        try {
            commonService.saveBody(body);
            return ResponseEntity.ok("ok");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }

    }

    @CrossOrigin
    @GetMapping("/profile/download")
    public void downloadProfile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Test_Results.xlsx";
        response.setHeader(headerKey, headerValue);
        profileService.downloadProfile(response);
    }

}
