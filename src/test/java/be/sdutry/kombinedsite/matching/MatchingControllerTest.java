package be.sdutry.kombinedsite.matching;

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
public class MatchingControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testIndex() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/matching").accept(MediaType.TEXT_HTML))
				.andExpect(status().isOk());
	}
}
