package be.sdutry.kombinedsite.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import be.sdutry.kombinedsite.questions.model.Question;
import be.sdutry.kombinedsite.questions.model.QuestionType;

@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@PostMapping("/questions/getting-to-know/admin")
	public ModelAndView addGettingToKnowQuestion(@RequestParam("question") String question, ModelMap model) {
		questionService.addGettingToKnowQuestion(question);

		return listGettingToKnowQuestion(model);
	}

	@GetMapping("/questions/getting-to-know/admin")
	public ModelAndView listGettingToKnowQuestion(ModelMap model) {
		List<Question> questions = questionService.getGettingToKnowQuestions();

		model.put("questions", questions);

		return new ModelAndView("questions/gettingtoknow/admin", model);
	}

	@PostMapping("/questions/getting-to-know/{questionId}/delete")
	public RedirectView deleteGettingToKnowQuestion(@PathVariable("questionId") long questionId) {
		questionService.deleteQuestion(questionId);

		return new RedirectView("/questions/getting-to-know/admin");
	}
	
	@PostMapping("/questions/starting-player/admin")
	public ModelAndView addStartingPlayerQuestion(@RequestParam("question") String question, ModelMap model) {
		questionService.addStartingPlayerQuestion(question);

		return listStartingPlayerQuestion(model);
	}

	@GetMapping("/questions/starting-player/admin")
	public ModelAndView listStartingPlayerQuestion(ModelMap model) {
		List<Question> questions = questionService.getStartingPlayerQuestions();

		model.put("questions", questions);

		return new ModelAndView("questions/startingplayer/admin", model);
	}

	@PostMapping("/questions/starting-player/{questionId}/delete")
	public RedirectView deleteStartingPlayerQuestion(@PathVariable("questionId") long questionId) {
		questionService.deleteQuestion(questionId);

		return new RedirectView("/questions/starting-player/admin");
	}
}
