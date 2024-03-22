package way11.project.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import way11.project.Entities.Question;

@Data
public class AnswerDTO {

    private Integer id;
    private String answer;
    private Integer point;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question answers;
    private Boolean selected;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Question getAnswers() {
        return answers;
    }

    public void setAnswers(Question answers) {
        this.answers = answers;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}

