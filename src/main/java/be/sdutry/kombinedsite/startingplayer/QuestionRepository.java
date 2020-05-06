package be.sdutry.kombinedsite.startingplayer;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "gettingToKnowQuestionRepository")
public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
	
	List<Question> findAll(Pageable pageable);
}
