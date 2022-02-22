package API_Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import Utilities.JSONHelper;

public class SEB_API extends BankingAPI {
	private final String API_KEY = "c30d43d643c24ea6ad21e8cf193e0f3f";
	private String clientID = "a8dcdb1969584a438594ce27c8df9aae";
	private String clientSecret = "e2111febac724febb85e3fe5ec27ce3f";
	private String authorizationURL = "https://api-sandbox.sebgroup.com/auth/v3/authorizations";
	SEB_API(){
		
	}
	@Override
	public void tryLogin(String ssn) throws Exception {
		String startMode = "qr";
		final String scope = "psd2_accounts psd2_payments";
		String jsonInput = "{\n"
				//+ "\"content\": {\n"
				//+ "\"properties\": {\n"
				+ JSONHelper.createStringAttribute("client_id", clientID, true)
				+ JSONHelper.createStringAttribute("lang", "en", true)
				+ JSONHelper.createStringAttribute("login_hint", ssn, true)
				+ JSONHelper.createStringAttribute("scope", scope, true)
				+ JSONHelper.createStringAttribute("start_mode", startMode, false)
				//+ "}\n"
				//+ "}\n"
				+ "}\n";
		
		URL url = new URL(authorizationURL);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		connection.setRequestProperty("Accept", "application/json");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setConnectTimeout(5000);
		
		
		
		System.out.println("Sending the following JSON to API:" + jsonInput);
		byte[] jsonBytes = jsonInput.getBytes("UTF-8");
		System.out.println("Are we here?0");
		// Write the JSON data
		connection.getOutputStream().write(jsonBytes);
		//connection.getOutputStream().flush();
		System.out.println("Are we here?1");
		// Read the response
		
		try {
		if(connection.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {
			System.out.println("Are we here?2");
			System.out.println("Error response from API: ");
			String response = readAllStream(connection.getErrorStream());
			System.out.println(response.toString());
		}
		else {
			System.out.println("Response from API: ");
			String response = readAllStream(connection.getInputStream());
			System.out.println(response.toString());
		}
		}
		catch(IOException err) {
			
			err.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SEB_API api = new SEB_API();
		String ssn = "200002257152";
		try {
			api.tryLogin(ssn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private String readAllStream(InputStream is) throws UnsupportedEncodingException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		StringBuilder response = new StringBuilder();
		String responseLine = null;
		while ((responseLine = br.readLine()) != null) {
			response.append(responseLine.trim());
		}
		return response.toString();
	}

}
