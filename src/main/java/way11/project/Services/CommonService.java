package way11.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import way11.project.Entities.Answer;
import way11.project.Entities.Profile;
import way11.project.Entities.ProfileAnswer;
import way11.project.Entities.Question;
import way11.project.Repositories.AnswerRepo;
import way11.project.dtos.CommonDTO;
import way11.project.Repositories.ProfileRepo;
import way11.project.Repositories.QuestionRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommonService {

    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private AnswerRepo answerRepo;

    public Profile saveBody(CommonDTO body){
        Profile profile = new Profile();
        profile.setWeight(body.getWeight());
        profile.setAge(body.getAge());
        profile.setHeight(body.getHeight());
        List<ProfileAnswer> temp = new ArrayList<>();
        body.getAnswers().stream().forEach(elem -> {
            ProfileAnswer part = new ProfileAnswer();
            if (elem != null) {
                part.setProfile(profile);
                part.setAnswer(answerRepo.findById(elem.getAnswer()));
                part.setQuestion(questionRepo.findById(elem.getQuestion()));
                temp.add(part);
            }
        });
        profile.setAnswers(temp);
        return profileRepo.save(profile);
    }

    public Iterable<Answer> setAnswers(List<Answer> answers){
        return answerRepo.saveAll(answers);
    }

    public Question setQuestion(Question question){
        for (Answer answer : question.getAnswers()) {
            answer.setAnswers(question);
        }
        return questionRepo.save(question);
    }

    public Iterable<Question> setQuestions(List<Question> questions){
        questions.stream().forEach(elem -> {
                    for (Answer answer : elem.getAnswers()) {
                        answer.setAnswers(elem);
                    }
                }
        );
        return questionRepo.saveAll(questions);
    }

}
