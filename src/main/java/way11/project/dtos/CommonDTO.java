package way11.project.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import way11.project.Entities.ProfileAnswer;
import way11.project.Entities.Question;

import java.util.List;

@Data
public class CommonDTO {

    private Integer age;
    private Integer height;
    private Integer weight;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "profileDTO")
    private List<ProfileAnswerDTO> answers; // Надо сделать другую дтошку, в которую сделать не обьект, а айди (А потом получать обьект по айди)

//    @ManyToOne
//    @JoinColumn(name="q_id")
//    private Question answers;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<ProfileAnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ProfileAnswerDTO> answers) {
        this.answers = answers;
    }
}
