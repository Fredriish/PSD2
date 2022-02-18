package API_Resources;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import org.apache.http.client.methods.HttpPost;

public class SEB_API extends BankingAPI {
	private HttpClient client;
	SEB_API(){
		client = HttpClient.newHttpClient();
	}
	@Override
	public void tryLogin() {
		String initiateLoginURL = "https://api-sandbox.sebgroup.com/auth/v3/authorizations";
		//List<Pair<String,String>>initiateRequestParams;
		HttpPost post = new HttpPost();
	}

}
