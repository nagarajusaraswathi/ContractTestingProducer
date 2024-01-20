package generate;

import com.contract.poc.example.ExampleApplication;
import com.contract.poc.example.Person;
import com.contract.poc.example.PersonRestController;
import com.contract.poc.example.PersonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = ExampleApplication.class)
public abstract class BaseClass {

	@Autowired
	PersonRestController personRestController;

	@MockBean
	PersonService personService;

	@BeforeEach public void setup() {
		RestAssuredMockMvc.standaloneSetup(personRestController);

		Mockito.when(personService.findPersonById(1L))
				.thenReturn(new Person(1L, "foo", "bee"));
	}

}
