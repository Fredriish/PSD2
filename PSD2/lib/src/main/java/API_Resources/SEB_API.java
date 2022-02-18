package API_Resources;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

public class SEB_API extends BankingAPI {
	private HttpClient client;
	private String clientID = "a8dcdb1969584a438594ce27c8df9aae";
	private String clientSecret = "e2111febac724febb85e3fe5ec27ce3f";
	SEB_API(){
		client = HttpClient.newHttpClient();
	}
	@Override
	public void tryLogin(String ssn) throws Exception {
	/*	URL url = new URL("https://api-sandbox.sebgroup.com/auth/v3/authorizations");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; utf-8");
		connection.setRequestProperty("Accept", "application/json");
		connection.setDoOutput(true);*/
		String jsonInput = "{"
				+ "\"content\": {"
				+  "\"properties\": {"
				
				+ "\"client_id\": " + "\"" + clientID + "\""
				+ "\"";
		
		System.out.println(jsonInput);
	}
	public static void main(String[] args) {
		SEB_API api = new SEB_API();
		String ssn = "";
		try {
			api.tryLogin(ssn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
