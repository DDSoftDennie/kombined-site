package be.sdutry.kombinedsite.gettingtoknow;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "StartingPlayerQuestionRepository")
public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
	
	List<Question> findAll(Pageable pageable);
}
