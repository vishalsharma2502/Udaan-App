package org.codejudge.sb.controller;

import org.codejudge.sb.model.ExceptionResponse;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.model.QuizQuestion;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> Hello(@NotNull @PathVariable String name) {
        return new ResponseEntity("Hello World" + name, HttpStatus.OK);
    }


    @GetMapping("/quiz/{quiz_Id}")
    public ResponseEntity<?> getQuizById(@NotNull @PathVariable Integer quiz_Id) {

        QuizQuestion response = quizService.getQuizByID(quiz_Id);
        if (response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);

    }


    @GetMapping("/quiz-questions/{quiz_Id}")
    public ResponseEntity<?> getQuiz(@NotNull @PathVariable Integer quiz_Id) {
        Quiz response = quizService.getQuiz(quiz_Id);
        response.setId(null);
        if (response != null)
            return new ResponseEntity<>(response, HttpStatus.OK);
        else
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);

    }

    @PostMapping(value = "/quiz")
    public ResponseEntity<?> createQuiz(@Valid @RequestBody Quiz quiz) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("failure", "Some Error Occurred");
        try {
            Quiz response = quizService.createQuiz(quiz);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
