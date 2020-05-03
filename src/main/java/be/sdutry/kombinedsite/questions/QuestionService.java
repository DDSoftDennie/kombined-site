package be.sdutry.kombinedsite.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.sdutry.kombinedsite.questions.model.Question;
import be.sdutry.kombinedsite.questions.model.QuestionType;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public Question addGettingToKnowQuestion(String question) {
		return addQuestion(buildQuestion(question, QuestionType.GETTING_TO_KNOW));
	}
	
	public List<Question> getGettingToKnowQuestions() {
		return getQuestionsByType(QuestionType.GETTING_TO_KNOW);
	}
	
	public void deleteQuestion(long questionId) {
		questionRepository.deleteById(questionId);
	}

	public Question addStartingPlayerQuestion(String question) {
		return addQuestion(buildQuestion(question, QuestionType.STARTING_PLAYER));
	}

	public List<Question> getStartingPlayerQuestions() {
		return getQuestionsByType(QuestionType.STARTING_PLAYER);
	}
	
	private List<Question> getQuestionsByType(QuestionType questionType) {
		return questionRepository.findByQuestionType(questionType);
	}
	
	private Question addQuestion(Question question) {
		questionRepository.save(question);
		
		return question;
	}
	
	private Question buildQuestion(String question, QuestionType questionType) {
		return Question.builder().question(question).questionType(questionType).build();
	}
	
}
