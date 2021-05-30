package org.codejudge.sb.service;

import org.codejudge.sb.model.Question;
import org.codejudge.sb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    public Question getQuestion(@NotNull Integer questionId) {

        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            return question.get();
        }
        return null;
    }

    public Question createQuestion(@NotNull Question question) {
        return questionRepository.save(question);
    }


    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    public void deleteQuestion(@NotNull Integer questionId) {
        questionRepository.deleteById(questionId);
    }

    public Question updateQuestion(@NotNull Integer id, @NotNull Question question) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question updatedQuestion = optionalQuestion.get();
            updatedQuestion.setName(question.getName());
            updatedQuestion.setOptions(question.getOptions());
            updatedQuestion.setPoints(question.getPoints());
            updatedQuestion.setCorrect_option(question.getCorrect_option());
            // updatedQuestion.setQuiz(question.getQuiz());
            return questionRepository.save(updatedQuestion);
        }
        return null;
    }

    public void deleteAllQuestions() {
        questionRepository.deleteAll();
    }

}
