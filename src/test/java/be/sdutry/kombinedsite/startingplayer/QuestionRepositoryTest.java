package be.sdutry.kombinedsite.startingplayer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EntityScan(value = {"be.sdutry.kombinedsite"})
@DataJpaTest
@SqlGroup({
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= "classpath:be/sdutry/kombinedsite/startingplayer/init-data.sql"),
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts="classpath:cleanup.sql")
})
public class QuestionRepositoryTest {
	@Autowired
	private QuestionRepository repository;
	
	@Test
	void testGetAll() {
		List<Question> questions = repository.findAll();
		
		assertThat(questions).hasSize(2);
		assertThat(questions.get(0).getId()).isEqualTo(1L);
		assertThat(questions.get(0).getQuestion()).isEqualTo("starting player question 1");
		assertThat(questions.get(1).getId()).isEqualTo(2L);
		assertThat(questions.get(1).getQuestion()).isEqualTo("starting player question 2");
	}
	
	@Test
	void testCount() {
		Long count = repository.count();
		
		assertThat(count).isEqualTo(2L);
	}
	
	@Test
	void testFindPaged() {
		Pageable page = PageRequest.of(1, 1);
		List<Question> questions = repository.findAll(page);
		
		assertThat(questions.size()).isEqualTo(1);
		assertThat(questions.get(0).getId()).isEqualTo(2L);
	}
	
	@Test
	void testFindById() {
		Question question = repository.findById(2L).get();
		
		assertThat(question.getId()).isEqualTo(2L);
		assertThat(question.getQuestion()).isEqualTo("starting player question 2");
	}
	
	@Test
	void testSave() {
		Question question = Question.builder().id(3L).question("starting player question 3").build();
		
		assertThat(repository.count()).isEqualTo(2L);
		repository.save(question);
		assertThat(question.getId()).isNotNull();
	}
}