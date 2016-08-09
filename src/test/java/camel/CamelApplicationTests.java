package camel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.poc.camel.CamelApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CamelApplication.class)
@WebAppConfiguration
public class CamelApplicationTests {

	@Test
	public void contextLoads() {
	}

}
