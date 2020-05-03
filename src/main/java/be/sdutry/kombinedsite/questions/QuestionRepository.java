package be.sdutry.kombinedsite.questions;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.sdutry.kombinedsite.questions.model.Question;
import be.sdutry.kombinedsite.questions.model.QuestionType;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findByQuestionType(QuestionType questionType);

	Question findById(long id);
}
