package be.sdutry.kombinedsite.matching;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MatchingController {

	@GetMapping("/matching")
	public ModelAndView index(Map<String, Object> model) {
		return new ModelAndView("matching/index", model);
	}

}
