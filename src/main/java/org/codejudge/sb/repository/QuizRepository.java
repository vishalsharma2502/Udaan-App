package org.codejudge.sb.repository;


import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    Optional<Quiz> findByName(String name);

    @Query("select new org.codejudge.sb.model.QuizQuestion(q.id,q.name,q.description) from Quiz q where q.id = ?1")
    QuizQuestion findByQuizId(Integer quizId);

}
