package way11.project.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import way11.project.Entities.Answer;
import way11.project.Entities.Profile;
import way11.project.Entities.Question;

@Data
public class ProfileAnswerDTO {

    @ManyToOne
    @JoinColumn(name="profile_id")
    private CommonDTO profile;
    private int question;
    private int answer;

    public CommonDTO getProfile() {
        return profile;
    }

    public void setProfile(CommonDTO profile) {
        this.profile = profile;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
