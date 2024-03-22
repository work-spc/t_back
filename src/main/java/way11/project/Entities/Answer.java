package way11.project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String answer;
    private Integer point;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question answers;
    @JsonIgnore
    private Boolean selected;

    public Integer getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public Integer getPoint() {
        return point;
    }

    public Question getAnswers() {
        return answers;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void setAnswers(Question answers) {
        this.answers = answers;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
