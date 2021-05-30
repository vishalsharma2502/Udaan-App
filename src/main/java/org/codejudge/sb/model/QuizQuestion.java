package org.codejudge.sb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizQuestion {

    private Integer id;
    private String name;
    private String description;


}
