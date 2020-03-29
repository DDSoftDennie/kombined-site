package be.sdutry.kombinedsite.user;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
	@GetMapping("/user/register")
	public ModelAndView register(Map<String, Object> model) {
		return new ModelAndView("user/register", model);
	}
	
	@GetMapping("/user/login")
	public ModelAndView login(Map<String, Object> model) {
		return new ModelAndView("user/login", model);
	}
}
