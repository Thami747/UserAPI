package com.thamiprojects.userapi;

import com.thamiprojects.userapi.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiApplicationTests {
	@LocalServerPort
	private int port;
	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate;

	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/client");
	}

	/**
	 * The below tests are to test creating a client.
	 */
	@Test
	public void testCreateClientEmptyFirstName() {
		User user = new User();
		user.setFirstName("");

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("Client firstName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientNullFirstName() {
		User user = new User();
		user.setFirstName(null);

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("Client firstName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientEmptyLastName() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("");

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("Client lastName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientNullLastName() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName(null);

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("Client lastName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientEmptyIdNumber() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("");

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientNullIdNumber() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber(null);

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientIdNumberContainsLessThanThirteendigits() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("921007533508");

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientIdNumberDuplicate() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("9210075335089");

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("Filed to create Client, either ID number or mobile number is duplicate.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientMobileNumberDuplicate() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("9210075335085");
		user.setMobileNumber("0721612718");

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("Filed to create Client, either ID number or mobile number is duplicate.", userResponse.getMessage());
	}

	@Test
	public void testCreateClientSuccess() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("9210075335082");
		user.setMobileNumber("0721612712");
		user.setAddress("109 Grant Street, Lilyvale, Benoni, 1515");

		User userResponse = restTemplate.postForObject(baseUrl+"/saveClient", user, User.class);
		assertEquals("Successfully created Client.", userResponse.getMessage());
	}

	/**
	 * The below tests are  for updating a client
	 */

	@Test
	public void testUpdateClientEmptyFirstName() {
		User user = new User();
		user.setFirstName("");

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("Client firstName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientNullFirstName() {
		User user = new User();
		user.setFirstName(null);

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("Client firstName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientEmptyLastName() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("");

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("Client lastName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientNullLastName() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName(null);

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("Client lastName cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientEmptyIdNumber() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("");

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientNullIdNumber() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber(null);

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientIdNumberContainsLessThanThirteendigits() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("921007533508");

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientDoesNotExist() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("9210075335085");
		user.setMobileNumber("0721612715");
		user.setAddress("777 Grant Street, Daveyton, Benoni, 2020");

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("Client does not exist!", userResponse.getMessage());
	}

	@Test
	public void testUpdateClientSuccess() {
		User user = new User();
		user.setFirstName("Peter");
		user.setLastName("Nkosi");
		user.setIdNumber("9210075335089");
		user.setMobileNumber("0721612718");
		user.setAddress("777 Grant Street, Daveyton, Benoni, 2020");

		User userResponse = restTemplate.postForObject(baseUrl+"/updateClient", user, User.class);
		assertEquals("Successfully updated Client.", userResponse.getMessage());
	}

	/**
	 * The below tests are to test searching for a client
	 */
	@Test
	public void testGetClientDoesNotExist() {
		User userResponse = restTemplate.getForObject(baseUrl+"/getClientById/9210075335088", User.class);
		assertEquals("Client does not exist.", userResponse.getMessage());
	}

	@Test
	public void testGetClientSuccess() {
		User userResponse = restTemplate.getForObject(baseUrl+"/getClientById/9210075335089", User.class);
		assertEquals("Successfully found client.", userResponse.getMessage());
	}

}
