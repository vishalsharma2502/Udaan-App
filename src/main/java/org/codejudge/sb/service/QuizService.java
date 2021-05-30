package org.codejudge.sb.service;

import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.model.QuizQuestion;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    public Quiz getQuiz(@NotNull Integer quizId) {

        Optional<Quiz> quiz = quizRepository.findById(quizId);

        if (quiz.isPresent()) {
            return quiz.get();
        }
        return null;
    }

    public QuizQuestion getQuizByID(@NotNull Integer quizId) {

        QuizQuestion quiz = quizRepository.findByQuizId(quizId);

        return quiz;
    }

    public Quiz createQuiz(@NotNull Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuiz() {
        return (List<Quiz>) quizRepository.findAll();
    }

    public void deleteQuiz(@NotNull Integer questionId) {
        quizRepository.deleteById(questionId);
    }

    public Quiz updateQuiz(@NotNull Integer id, @NotNull Quiz quiz) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (optionalQuiz.isPresent()) {
            Quiz updatedQuiz = optionalQuiz.get();
            updatedQuiz.setName(quiz.getName());
            updatedQuiz.setDescription(quiz.getDescription());
            return quizRepository.save(updatedQuiz);
        }
        return null;
    }

    public void deleteAllQuiz() {
        quizRepository.deleteAll();
    }
}
