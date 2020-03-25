package be.sdutry.kombinedsite.matching;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MatchingControllerIT {
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/matching");
	}

	@Test
	public void testIndex() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		//TODO: make test actualy test something
		System.out.println(response.getBody());
	}
}
