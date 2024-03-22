package way11.project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="ProfileAnswer")
public class ProfileAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="profile_id")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name="answer_id")
    private Answer answer;


//    @ManyToOne
//    @JoinColumn(name="question_id")
//    private List<Question> questions;
//    @ManyToOne
//    @JoinColumn(name="answer")
//    private Answer answers;


    //    @OneToMany(cascade = CascadeType.ALL,mappedBy = "questions")
//    private List<Profile> profiles;
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "profile")
//    private List<Question> questions;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
