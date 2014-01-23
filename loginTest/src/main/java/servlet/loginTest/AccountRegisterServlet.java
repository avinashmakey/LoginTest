package servlet.loginTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;

/**
 * Servlet implementation class AccountRegisterServlet
 */
public class AccountRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CloseableHttpResponse postresponse = null;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CloseableHttpClient httpclient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		
		String repString = httpPost(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"), request.getParameter("is_subscribed"), request.getParameter("password"), request.getParameter("confirmation"), httpclient);
		
		if(postresponse.getStatusLine().getStatusCode()==200){
			 request.getRequestDispatcher("/success.jsp").forward(request, response);
		 }else{
			 request.getRequestDispatcher("/failure.jsp").forward(request, response);
		 }
	}
	
	public String httpPost(String firstName,String lastName,String email,String is_Subscribed,String password,String conformation, CloseableHttpClient httpclient) {
		String responseString = null;
		
		try {

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("firstname", firstName));
		formparams.add(new BasicNameValuePair("lastname", lastName));
		formparams.add(new BasicNameValuePair("email", email));
		formparams.add(new BasicNameValuePair("is_subscribed",is_Subscribed));
		formparams.add(new BasicNameValuePair("password", password));
		formparams.add(new BasicNameValuePair("confirmation", conformation));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://myopenissues.com/magento/index.php/customer/account/createpost/");
		
		// add header
		httppost.setHeader("User-Agent", "Mozilla/5.0");
		httppost.setHeader("cookie", "cookie");
		httppost.setEntity(entity);

		//http post request
		postresponse = httpclient.execute(httppost);

		System.out.println(postresponse.getStatusLine().getStatusCode());

		InputStream ips = postresponse.getEntity().getContent();
		BufferedReader buf = new BufferedReader(new InputStreamReader(ips,
				"UTF-8"));
		StringBuilder sb = new StringBuilder();
		int c;
		while ((c = buf.read()) != -1) {
			sb.append((char) c);
		}
		responseString = sb.toString();
		System.out.println(responseString);
		

	} catch (ClientProtocolException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		return responseString;
		
	}

}
