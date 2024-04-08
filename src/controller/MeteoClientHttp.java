package controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class MeteoClientHttp {
	
	public MeteoClientHttp() {
		
		
	}
	
	
	
	public void login() {
		String requestBody = "--ed5636f3-fc21-4b6a-8404-f41d144329d7\r\n" +
				 "Content-Disposition: form-data; name=\"email\"\r\n" +
				 "Content-Type: text/plain; charset=utf-8\r\n" +
				 "\r\n" +
				 "andre.bonifazi@gmail.com\r\n" +
				 "--ed5636f3-fc21-4b6a-8404-f41d144329d7\r\n" +
				 "Content-Disposition: form-data; name=\"password\"\r\n" +
				 "Content-Type: text/plain; charset=utf-8\r\n" +
				 "\r\n" +
				 "V4ll4ur1\r\n" +
				 "--ed5636f3-fc21-4b6a-8404-f41d144329d7--\r\n";
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("https://api.meteonetwork.it/v3/login"))
					.version(HttpClient.Version.HTTP_1_1)
					//.header("Host", "api.meteonetwork.it")
					.header("Content-Type", "multipart/form-data; boundary=ed5636f3-fc21-4b6a-8404-f41d144329d7")
					.header("Cache-Control","no-cache")
					.header("Pragma","no-cache")
					.header("User-Agent","Java/22-ea")
					.header("Accept","*/*")
					//.header("Connection","keep-alive")
					//.header("Content-Length","339")	
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.build();
			HttpClient client = HttpClient.newHttpClient();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	 
	/*CloseableHttpClient httpClient = HttpClients.createDefault();
	/* HttpPost uploadFile = new HttpPost("...");
	MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);

	// This attaches the file to the POST:
	File f = new File("[/path/to/upload]");
	builder.addBinaryBody(
    	"file",
    	new FileInputStream(f),
    	ContentType.APPLICATION_OCTET_STREAM,
    	f.getName()
	);

	HttpEntity multipart = builder.build();
	uploadFile.setEntity(multipart);
	CloseableHttpResponse response = httpClient.execute(uploadFile);
	HttpEntity responseEntity = response.getEntity();

	 */
}
