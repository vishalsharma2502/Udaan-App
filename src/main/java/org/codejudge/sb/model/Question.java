package org.codejudge.sb.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class Question implements Serializable {


    private static final long serialVersionUID = 4123647052540747447L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "question_id")
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String options;

    @NotNull
    private String correct_option;

    @Column(name = "quiz_question_id")
    private Integer quiz;

    @NotNull
    private Integer points;


    public Question(String name, String options, String correct_option, Integer quiz, Integer points) {
        this.name = name;
        this.options = options;
        this.correct_option = correct_option;
        this.quiz = quiz;
        this.points = points;
    }
}
