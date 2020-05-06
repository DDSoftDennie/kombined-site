package be.sdutry.kombinedsite.matching;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MatchingController {

	@GetMapping("/matching")
	public ModelAndView index(ModelMap model) {
		return new ModelAndView("matching/index", model);
	}

}
