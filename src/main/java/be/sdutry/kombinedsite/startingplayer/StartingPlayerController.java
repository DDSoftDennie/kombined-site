package be.sdutry.kombinedsite.startingplayer;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import be.sdutry.kombinedsite.util.controller.PdfRenderingController;
import be.sdutry.kombinedsite.util.pdf.PdfService;

@RestController
@RequestMapping("starting-player")
public class StartingPlayerController implements PdfRenderingController {
	@Autowired
	private StartingPlayerService startingPlayerService;
	@Autowired
	private PdfService pdfService;

	@GetMapping("/admin")
	public ModelAndView getQuestionsAdmin(ModelMap model) {
		List<Question> questions = startingPlayerService.getAllQuestions();

		model.put("questions", questions);

		return new ModelAndView("startingplayer/admin", model);
	}

	@PostMapping("/{questionId}/delete")
	public RedirectView deleteQuestion(@PathVariable("questionId") long questionId) {
		startingPlayerService.deleteQuestion(questionId);

		return new RedirectView("/starting-player/admin");
	}

	@PostMapping("/admin")
	public ModelAndView addQuestion(@RequestParam("question") String question, ModelMap model) {
		startingPlayerService.addQuestion(question);

		return getQuestionsAdmin(model);
	}

	@GetMapping("/random")
	public ModelAndView getRandomStartingPlayerQuestion(ModelMap model) {
		Question question = startingPlayerService.getRandomQuestion();

		model.put("question", question);

		return new ModelAndView("startingplayer/random", model);
	}

	@GetMapping("/export/PDF")
	public ResponseEntity<byte[]> exportPdf(ModelMap model) {
		List<Question> questions = startingPlayerService.getAllQuestions();
		List<String> questionLines = questions.stream().map(question -> question.getQuestion())
				.collect(Collectors.toList());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		pdfService.writeLinesAsTable(questionLines, baos, "Startspeler bepalen");

		return createPdfResponse(baos, "startspelerBepalen.pdf");
	}
}
