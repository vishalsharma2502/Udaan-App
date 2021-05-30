package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@Data
@NoArgsConstructor
//@JsonIgnoreProperties(value = { "id" })
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Quiz implements Serializable {


    private static final long serialVersionUID = -3370057389416963282L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;

    @OneToMany(targetEntity = Question.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_question_id", referencedColumnName = "id")
    private List<Question> questions = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) && Objects.equals(name, quiz.name) && Objects.equals(description, quiz.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
