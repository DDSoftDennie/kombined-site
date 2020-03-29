package be.sdutry.kombinedsite.user;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIT {
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/user");
	}
	
	@Test
	public void testRegiter() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString() + "/register", String.class);
		response.getBody().contains("Registreer als nieuwe gebruiker");
	}
	
	@Test
	public void testLogin() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString() + "/register", String.class);
		response.getBody().contains("Aanmelden");
	}
}
