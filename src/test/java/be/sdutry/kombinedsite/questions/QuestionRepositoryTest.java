package be.sdutry.kombinedsite.questions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import be.sdutry.kombinedsite.questions.model.Question;
import be.sdutry.kombinedsite.questions.model.QuestionType;

@ExtendWith(SpringExtension.class)
@EntityScan(value = {"be.sdutry.kombinedsite.questions"})
@DataJpaTest
@SqlGroup({
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= "classpath:be/sdutry/kombinedsite/questions/init-data.sql"),
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts="classpath:be/sdutry/kombinedsite/questions/cleanup.sql")
})
public class QuestionRepositoryTest {
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	public void testFindById() {
		Question question = questionRepository.findById(1);
		
		assertThat(question.getQuestionType()).isEqualTo(QuestionType.GETTING_TO_KNOW);
		assertThat(question.getQuestion()).isEqualTo("getting to know question 1");
	}
	
	@Test
	public void testFindByQuestionType() {
		List<Question> questions = questionRepository.findByQuestionType(QuestionType.GETTING_TO_KNOW);
		
		assertThat(questions).hasSize(2);
		assertThat(questions.get(0).getQuestionType()).isEqualTo(QuestionType.GETTING_TO_KNOW);
		assertThat(questions.get(0).getId()).isEqualTo(1L);
		assertThat(questions.get(1).getQuestionType()).isEqualTo(QuestionType.GETTING_TO_KNOW);
		assertThat(questions.get(1).getId()).isEqualTo(2L);
	}
}
