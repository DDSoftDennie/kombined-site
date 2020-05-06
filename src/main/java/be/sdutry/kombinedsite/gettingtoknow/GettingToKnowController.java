package be.sdutry.kombinedsite.gettingtoknow;

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


@RestController
public class GettingToKnowController {
	@Autowired
	private GettingToKnowService gettingToKnowService;
	
	@GetMapping("/getting-to-know/admin")
	public ModelAndView getQuestionsAdmin(ModelMap model) {
		List<Question> questions = gettingToKnowService.getAllQuestions();
		
		model.put("questions", questions);
		
		return new ModelAndView("gettingtoknow/admin", model);
	}
	
	
	@PostMapping("/getting-to-know/{questionId}/delete")
	public RedirectView deleteQuestion(@PathVariable("questionId") long questionId) {
		gettingToKnowService.deleteQuestion(questionId);

		return new RedirectView("/getting-to-know/admin");
	}
	
	@PostMapping("/getting-to-know/admin")
	public ModelAndView addQuestion(@RequestParam("question") String question, ModelMap model) {
		gettingToKnowService.addQuestion(question);

		return getQuestionsAdmin(model);
	}
	
	@GetMapping("/getting-to-know/random")
	public ModelAndView getRandomGettingToKnowQuestion(ModelMap model) {
		Question question = gettingToKnowService.getRandomQuestion();

		model.put("question", question);

		return new ModelAndView("gettingtoknow/random", model);
	}
}
