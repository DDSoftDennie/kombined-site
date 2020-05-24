package be.sdutry.kombinedsite.gettingtoknow;

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
@RequestMapping("getting-to-know")
public class GettingToKnowController implements PdfRenderingController {
	@Autowired
	private GettingToKnowService gettingToKnowService;
	@Autowired
	private PdfService pdfService;

	@GetMapping("/admin")
	public ModelAndView getQuestionsAdmin(ModelMap model) {
		List<Question> questions = gettingToKnowService.getAllQuestions();

		model.put("questions", questions);

		return new ModelAndView("gettingtoknow/admin", model);
	}

	@PostMapping("/{questionId}/delete")
	public RedirectView deleteQuestion(@PathVariable("questionId") long questionId) {
		gettingToKnowService.deleteQuestion(questionId);

		return new RedirectView("/getting-to-know/admin");
	}

	@PostMapping("/admin")
	public ModelAndView addQuestion(@RequestParam("question") String question, ModelMap model) {
		gettingToKnowService.addQuestion(question);

		return getQuestionsAdmin(model);
	}

	@GetMapping("/random")
	public ModelAndView getRandomGettingToKnowQuestion(ModelMap model) {
		Question question = gettingToKnowService.getRandomQuestion();

		model.put("question", question);

		return new ModelAndView("gettingtoknow/random", model);
	}

	@GetMapping("/export/PDF")
	public ResponseEntity<byte[]> exportPdf(ModelMap model) {
		List<Question> questions = gettingToKnowService.getAllQuestions();
		List<String> questionLines = questions.stream().map(question -> question.getQuestion())
				.collect(Collectors.toList());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		pdfService.writeLinesAsParagraphs(questionLines, baos, "Kennismakingsvragen");

		return createPdfResponse(baos, "Kennismakingsvragen.pdf");
	}

}
