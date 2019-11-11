package com.ae.assignment;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import junit.framework.Assert;

@SpringBootTest
class AeMicroserviceApplicationTests {

	String url = "http://localhost:8080/userinfo";

	@Test
	public void checkContent() throws ClientProtocolException, IOException {
		   // Given
		   String jsonMimeType = "application/json";
		   HttpUriRequest request = new HttpGet(url);
		 
		   // When
		   HttpResponse response = HttpClientBuilder.create().build().execute( request );
		 
		   // Then
		   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		   assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	public void checkGetService() throws ClientProtocolException, IOException {
		   // Given
		   HttpUriRequest request = new HttpGet(url);
		 
		   // When
		   HttpResponse response = HttpClientBuilder.create().build().execute( request );
		 
		   // Then
		   assertEquals(response.getStatusLine().getStatusCode(),200);
	}
	
	@Test
	public void checkCreateUserPostService() throws ClientProtocolException, IOException {
		String payload = "{" + 
				"	\"userName\":\"jketan21\"," + 
				"	\"city\":\"Santa Clara\"" + 
				"}";
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
		assertEquals(response.getStatusLine().getStatusCode(),200);

	}
}
