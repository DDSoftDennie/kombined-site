package be.sdutry.kombinedsite.user;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testLogin() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/user/login").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testRegister() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/user/register").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk());
	}
}
