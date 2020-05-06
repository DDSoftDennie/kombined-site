package be.sdutry.kombinedsite.startingplayer;

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
public class StartingPlayerController {
	@Autowired
	private StartingPlayerService startingPlayerService;
	
	@GetMapping("/starting-player/admin")
	public ModelAndView getQuestionsAdmin(ModelMap model) {
		List<Question> questions = startingPlayerService.getAllQuestions();
		
		model.put("questions", questions);
		
		return new ModelAndView("startingplayer/admin", model);
	}
	
	
	@PostMapping("/starting-player/{questionId}/delete")
	public RedirectView deleteQuestion(@PathVariable("questionId") long questionId) {
		startingPlayerService.deleteQuestion(questionId);

		return new RedirectView("/starting-player/admin");
	}
	
	@PostMapping("/starting-player/admin")
	public ModelAndView addQuestion(@RequestParam("question") String question, ModelMap model) {
		startingPlayerService.addQuestion(question);

		return getQuestionsAdmin(model);
	}
	
	@GetMapping("/starting-player/random")
	public ModelAndView getRandomStartingPlayerQuestion(ModelMap model) {
		Question question = startingPlayerService.getRandomQuestion();

		model.put("question", question);

		return new ModelAndView("startingplayer/random", model);
	}
}

