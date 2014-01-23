import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.junit.Test;

import servlet.loginTest.AccountRegisterServlet;


public class LoginRegisterJunitTest {
	CloseableHttpClient httpclient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();

	/*
	 * Test to verify new account creation.
	 * Need to send unique emailId for this test to pass
	 */
	@Test
	public void testAccountRegisterServlet() {

		AccountRegisterServlet ars = new AccountRegisterServlet();
		String out = ars.httpPost("Joe", "Zimmerlin", "Joe2@gmail.com", "1", "1234ab", "1234ab", httpclient);
		System.out.println(out);

		assertEquals(true,out.contains("Customer Login"));
		
	}

}
