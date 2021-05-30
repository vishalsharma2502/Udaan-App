package org.codejudge.sb.controller;

import org.codejudge.sb.model.ExceptionResponse;
import org.codejudge.sb.model.Question;
import org.codejudge.sb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/questions")
    public ResponseEntity<?> createQuestion(@Valid @RequestBody Question question) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("failure", "Some Error Occurred");
        System.out.println(question.toString());
        Question response = questionService.createQuestion(question);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }


    @GetMapping("/questions/{question_id}")
    public ResponseEntity<?> getQuizById(@NotNull @PathVariable Integer question_id) {

        Question response = questionService.getQuestion(question_id);
        if (response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);

    }

}