package be.sdutry.kombinedsite.gettingtoknow;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GettingToKnowService {
	@Autowired
	private QuestionRepository repository;
	
	public List<Question> getAllQuestions() {
		return repository.findAll();
	}
	
	public Question getRandomQuestion() {
		long amountOfRows = repository.count();
		Random random = new Random();
		int pageNumber = random.nextInt((int) amountOfRows);
		Pageable page = PageRequest.of(pageNumber, 1);
		
		List<Question> questions = repository.findAll(page);
		
		return questions.get(0);
	}

	public void deleteQuestion(long questionId) {
		repository.deleteById(questionId);
	}

	public void addQuestion(String question) {
		repository.save(buildQuestion(question));
	}
	
	private Question buildQuestion(String question) {
		return Question.builder().question(question).build();
	}
	
}
