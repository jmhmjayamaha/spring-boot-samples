package lk.harshana;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class ApplicationTests.
 *
 * @author Harshana
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class ApplicationTests {

	/** The port. */
	@LocalServerPort
	private int port;

	/** The mgt. */
	@Value("${local.management.port}")
	private int mgt;

	/** The test rest template. */
	@Autowired
	private TestRestTemplate testRestTemplate;

	/**
	 * Test greeting controller.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGreetingController() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/greeting", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	/**
	 * Test management endpoint.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testManagementEndpoint() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.mgt + "/info", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
